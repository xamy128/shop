package com.sample.shop.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

/**
 * Read and return messages from messages file
 *
 * @author Ammarah Shakeel
 */
@Component
public class TemplateUtils {
    private  MessageSource messageSource;

    @Autowired
    public TemplateUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String message(String key) {
        return messageSource.getMessage(key, null , Locale.US);
    }
}
