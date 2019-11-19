package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Address;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.enums.RoleEnum;
import com.ocr.noel.escalade2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ValidateObjectService validateObjectService;

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findByIdFetchAddress(Integer id) {
        return userRepository.findByIdFetchAddress(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public boolean isExistingEmail(String email) {
        User user = findByEmail(email);
        return user != null;
    }

    /**
     * This method save a new user
     *
     * @param email           email
     * @param password        pwd
     * @param passwordconfirm the confirm pwd
     * @param firstname       his first name
     * @param lastname        his last name
     * @param modelMap        the modelMap to add new attributs
     * @return true if all is ok false otherwise
     */
    public boolean setNewUser(String email, String password, String passwordconfirm, String firstname, String lastname, ModelMap modelMap) {
        User userExist = findByEmail(email);
        if (userExist != null) {
            modelMap.addAttribute("error", "l'utilisateur existe déjà!");
            return false;
        }
        User user = new User();
        if (password != null && password.equals(passwordconfirm)) {
            user.setPwd(password);
        } else {
            modelMap.addAttribute("error", "les mots de passe ne correspondent pas!");
            return false;
        }
        if (firstname == null || firstname.length() < 1 || lastname == null || lastname.length() < 1) {
            modelMap.addAttribute("error", "Nom et prénom demandés");
            return false;
        }
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setRole(RoleEnum.ROLE_USER.getNum());
        boolean error = validateObjectService.validate(modelMap, user);
        if (!error) {
            save(user);
            modelMap.addAttribute("message", "Enregistrement reussi");
            return true;
        }
        return false;
    }

    public User getUserFromPrincipalAndDB(Principal principal) {
        User userDB = null;
        try {
            if (principal != null) {
                userDB = ((MyUserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
                userDB = findByIdFetchAddress(userDB.getId());
            }
        } catch (Exception e) {
            return null;
        }
        return userDB;
    }

    public void getHtmlFormMonCompte(Principal principal, ModelMap modelMap) {
        User user = getUserFromPrincipalAndDB(principal);
        modelMap.addAttribute("email", user.getEmail());
        modelMap.addAttribute("firstname", user.getFirstName());
        modelMap.addAttribute("lastname", user.getLastName());
        modelMap.addAttribute("phonenumber", user.getPhonenumber());
        Address address = user.getAddress();
        if (address != null) {
            modelMap.addAttribute("address", address.getAddress());
            modelMap.addAttribute("city", address.getCity());
            modelMap.addAttribute("zipcode", address.getZipcode());
            modelMap.addAttribute("country", address.getCountry());
        }
    }

    public boolean updateUserInformation(String email, String password, String passwordconfirm, String firstname,
                                         String lastname, String phonenumber, String address, String city,
                                         String zipcode, String country, Principal principal, ModelMap modelMap) {
        boolean isOk = true;
        User user = getUserFromPrincipalAndDB(principal);
        if (user == null) return false;
        if (email != null && email.length() > 0 && !isExistingEmail(email)) {
            user.setEmail(email);
        }
        if (password != null && password.length() > 0) {
            if (password.length() <= 100 && password.equals(passwordconfirm)) {
                user.setPwd(password);
            } else  {
                modelMap.addAttribute("passworderror", "erreur");
            }
        }
        if (firstname != null && firstname.length() > 0 && firstname.length() <= 50) user.setFirstName(firstname);
        if (lastname != null && lastname.length() > 0 && lastname.length() <= 50) user.setLastName(lastname);
        if (phonenumber != null && phonenumber.length() > 0) {
            phonenumber = phonenumber.replace(" ", "").replace(".","").replace("-","");
            if (phonenumber.length() <= 10) user.setPhonenumber(phonenumber);
        }
        if (user.getAddress() == null) {
            user.setAddress(new Address());
        }
        if (address != null && address.length() > 0 && address.length() <= 255) user.getAddress().setAddress(address);
        if (city != null && city.length() > 0 && city.length() <= 50) user.getAddress().setCity(city);
        if (zipcode != null && zipcode.length() > 0 && zipcode.length() <= 5) user.getAddress().setZipcode(zipcode);
        if (country != null && country.length() > 0 && country.length() <= 50) user.getAddress().setCountry(country);
        save(user);
        getHtmlFormMonCompte(principal, modelMap);
        return isOk;
    }
}
