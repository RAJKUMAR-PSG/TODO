package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    public Todo getTodoWithId(@PathVariable int id){
        return todoService.getOneTodoWithId(id);
    }

    @PatchMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        return todoService.updateTodoFields(id, todo);
    }

}
