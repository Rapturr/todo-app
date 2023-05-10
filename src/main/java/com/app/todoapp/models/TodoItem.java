package com.app.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
public class TodoItem {

    @Id
    @SequenceGenerator(
            name = "task_id_sequence",
            sequenceName = "task_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    private long id;
    private String description;
    private boolean complete;
    private Instant createdDate;
    private Instant modifiedDate;

    public TodoItem(){

    }

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("TodoItem{id=%d, description='%s', complete = '%s', createdDate='%s', modifiedDate='%s'}",id,description,complete,createdDate,modifiedDate);
    }
}
