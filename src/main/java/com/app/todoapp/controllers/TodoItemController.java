package com.app.todoapp.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoItemController {

    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);
    @GetMapping("/")
    public ModelAndView index(){
        logger.debug("request to GET index");
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
