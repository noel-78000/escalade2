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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @return true if all is ok false otherwise
     */
    public Map<String, String> setNewUser(String email, String password, String passwordconfirm, String firstname, String lastname) {
        Map<String, String> mapModel = new HashMap<>();
        if (isExistingEmail(email)) {
            mapModel.put("error", "l'utilisateur existe déjà!");
            return mapModel;
        }
        User user = new User();
        if (password != null && password.equals(passwordconfirm)) {
            user.setPwd(password);
        } else {
            mapModel.put("error", "les mots de passe ne correspondent pas!");
            return mapModel;
        }
        if (firstname == null || firstname.length() < 1 || lastname == null || lastname.length() < 1) {
            mapModel.put("error", "Nom et prénom demandés");
            return mapModel;
        }
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setRole(RoleEnum.ROLE_USER.getNum());
        Map<String, String> mapError = validateObjectService.validate(user);
        if (mapError.size() == 0) {
            save(user);
            mapModel.put("message", "Enregistrement reussi");
            return mapModel;
        } else {
            StringBuffer sb = new StringBuffer("enregistrement non approuvé");
            mapError.forEach((k, v) -> {
                sb.append(", ");
                sb.append(v);
            });
            mapModel.put("error", sb.toString());
        }
        return mapModel;
    }

    /**
     * get user from principal and if existing then DataBase
     *
     * @param principal the logued user
     * @return user updated
     */
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
            } else {
                modelMap.addAttribute("passworderror", "erreur");
                isOk = false;
            }
        }
        if (firstname != null && firstname.length() > 0 && firstname.length() <= 50) user.setFirstName(firstname);
        if (lastname != null && lastname.length() > 0 && lastname.length() <= 50) user.setLastName(lastname);
        if (phonenumber != null && phonenumber.length() > 0) {
            phonenumber = phonenumber.replace(" ", "").replace(".", "").replace("-", "");
            if (phonenumber.length() <= 10) user.setPhonenumber(phonenumber);
        }
        if (user.getAddress() == null) {
            user.setAddress(new Address());
        }
        if (address != null && address.length() > 0 && address.length() <= 255) user.getAddress().setAddress(address);
        if (city != null && city.length() > 0 && city.length() <= 50) user.getAddress().setCity(city);
        if (zipcode != null && zipcode.length() > 0 && zipcode.length() <= 5) user.getAddress().setZipcode(zipcode);
        if (country != null && country.length() > 0 && country.length() <= 50) user.getAddress().setCountry(country);
        Map<String, String> mapError = validateObjectService.validate(user);
        if (mapError.size() == 0) {
            save(user);
            getHtmlFormMonCompte(principal, modelMap);
        } else {
            getHtmlFormMonCompte(principal, modelMap);
            return false;
        }
        return isOk;
    }

    /**
     * if the user is at least an association member return true otherwise false
     *
     * @param principal principal logued
     * @return if is association member or more
     */
    public boolean isAtLeastAssociationLevel(Principal principal) {
        User user = getUserFromPrincipalAndDB(principal);
        return isAtLeastAssociationLevelFromUser(user);
    }

    public boolean isAtLeastAssociationLevelFromUser(User user) {
        if (user == null) return false;
        RoleEnum role = RoleEnum.getRole(user.getRole());
        if (role != null && RoleEnum.ROLE_ASSO.getNum() <= role.getNum()) return true;
        return false;
    }
}
