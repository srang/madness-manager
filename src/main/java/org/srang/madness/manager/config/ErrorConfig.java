package org.srang.madness.manager.config;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.exceptions.TemplateProcessingException;

/**
 * Created by srang on 1/15/17.
 */
@ControllerAdvice
@Log
public class ErrorConfig {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TemplateProcessingException.class)
    public void handle(TemplateProcessingException ex) {
        log.severe(ex.getTemplateName() + " threw exception");
        log.severe(ex.getMessage());
    }
}
