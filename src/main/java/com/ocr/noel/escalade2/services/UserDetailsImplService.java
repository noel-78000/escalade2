package com.ocr.noel.escalade2.services;


import com.ocr.noel.escalade2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class UserDetailsImplService implements UserDetailsService {

    @Autowired
    UserService userService;

    public UserDetailsImplService() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
        User user = findUserbyUername(email);

        UserBuilder builder = null;
        if (user != null) {
            //builder = org.springframework.security.core.userdetails.User.withUsername(username);
            //builder = org.springframework.security.core.userdetails.User.withUserDetails(new MyUserPrincipal(user));
            //builder.password(new BCryptPasswordEncoder().encode(/*user.getPassword()*/"admin123"));
//            if (user != null && user.getRole() == 2) {
//                builder.roles("ADMIN");
//            } else {
//                builder.roles("USER");
//            }
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return new MyUserPrincipal(user);
    }

    private User findUserbyUername(String email) {
        return userService.findByEmail(email);
    }
}
