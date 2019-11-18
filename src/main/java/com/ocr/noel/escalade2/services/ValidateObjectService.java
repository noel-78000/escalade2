package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.validation.Validator;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class ValidateObjectService {
    private final Logger log = LogManager.getLogger(ValidateObjectService.class);

    @Autowired
    Validator validator;

    public boolean validate(ModelMap modelMap, Object object) {
        log.info("dans ValidateObjectService");
        AtomicBoolean errorRep = new AtomicBoolean(false);
        if (object.getClass().equals(User.class)) {
            User user = (User) object;
            validator.validate(user).forEach(error -> {
                errorRep.set(true);
                String label =  (String) error.getConstraintDescriptor().getAttributes().get("label");
                log.debug("label: {}", label);
                String message = (String) error.getConstraintDescriptor().getAttributes().get("message");
                log.debug("message: {}", message);
                modelMap.addAttribute(label, message);
            });
        }
        return errorRep.get();
    }
}
