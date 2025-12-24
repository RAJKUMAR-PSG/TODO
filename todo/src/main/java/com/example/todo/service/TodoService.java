package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Todo> getAllTodo(){
        List<Todo> allTodos = todoRepository.getAllTodo();
        return allTodos;
    }
    public Todo getOneTodoWithId(int id){
        Todo todo = todoRepository.getOneTodoWithId(id);
        return todo;
    }
    public Todo updateTodoFields(int id, Todo todo){
        Todo updatedTodo = todoRepository.updateTodoFields(id, todo);
        return updatedTodo;
    }
}