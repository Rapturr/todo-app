package com.app.todoapp.config;

import com.app.todoapp.models.TodoItem;
import com.app.todoapp.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TodoItemDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadInitialData();
    }
    private void loadInitialData(){
        if(todoItemRepository.count() == 0){
            TodoItem todoItem1 = new TodoItem("Task1");
            TodoItem todoItem2 = new TodoItem("Task2");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
        logger.info("number of TodoItems: {}", todoItemRepository.count());
    }
}
