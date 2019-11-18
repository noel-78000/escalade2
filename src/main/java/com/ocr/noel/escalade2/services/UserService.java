package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.enums.RoleEnum;
import com.ocr.noel.escalade2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

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
}
