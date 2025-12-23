package com.example.todo.repo;
import com.example.todo.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

    private final JdbcTemplate jdbcTemplate;

    public TodoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Todo todo){
        String sql = "insert into todos (title) values (?)";
        jdbcTemplate.update(sql, todo.getTitle());
    }
}
