package com.ocr.noel.escalade2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

@Service
public class MessageSourceService {

    @Autowired
    MessageSource messageSource;

    public String getMessage(String key) {
        try {
            String value = messageSource.getMessage(key, null, null);
            if (value != null) {
                return value;
            }
        } catch (NoSuchMessageException e) {
            return "";
        }
        return "";
    }
}
