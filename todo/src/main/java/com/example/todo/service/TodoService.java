package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo saveTodo(Todo todo){
        todoRepository.save(todo);
        return todo;
    }
}