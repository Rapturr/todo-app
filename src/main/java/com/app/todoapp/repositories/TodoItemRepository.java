package com.app.todoapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.app.todoapp.models.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
