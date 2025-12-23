package com.example.todo.model;

public class Todo {
    private int id;
    private String title;
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
