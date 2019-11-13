package com.ocr.noel.escalade2.utils;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.MyUserPrincipal;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;

public class UserUtil {
    public static User getUserFromPrincipal(Principal principal) {
        User userDB = null;
        try {
            if (principal != null) {
                userDB = ((MyUserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
            }
        } catch (Exception e) {
            return null;
        }
        return userDB;
    }
}
