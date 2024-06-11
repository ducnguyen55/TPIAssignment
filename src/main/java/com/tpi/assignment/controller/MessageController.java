package com.tpi.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class MessageController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/some-path")
    public String someMethod(Locale locale, Model model) {
        String message = messageSource.getMessage("currency.label.code", null, locale);
        model.addAttribute("message", message);
        return "some-view";
    }
}
