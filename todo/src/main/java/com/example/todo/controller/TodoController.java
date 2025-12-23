package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    private TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }
}
