package com.app.todoapp.controllers;

import com.app.todoapp.models.TodoItem;
import com.app.todoapp.repositories.TodoItemRepository;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;

@Controller
public class TodoItemController {

    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index(){
        logger.debug("request to GET index");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("todoItems", todoItemRepository.findAll());
        return mav;
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem todoItem, BindingResult result, Model model){
        if(result.hasErrors()){
            todoItem.setId(id);
            return "update-todo-item";
        }
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
