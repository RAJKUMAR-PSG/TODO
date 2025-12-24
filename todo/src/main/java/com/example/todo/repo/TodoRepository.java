package com.example.todo.repo;
import com.example.todo.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Todo> getAllTodo(){
        String sql = "select id, title from todos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getInt("id"));
            todo.setTitle(rs.getString("title"));
            return todo;
        });
    }

    public Todo getOneTodoWithId(int id){
        String sql =  "select id, title from todos where id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getInt("id"));
            todo.setTitle(rs.getString("title"));
            return todo;
        }, id);
    }

    public Todo updateTodoFields(int id, Todo todo){
        String sql = "update todos set title = ? where id = ?";
        jdbcTemplate.update(sql, todo.getTitle(), id);
        return todo;
    }

    public void deleteMapping(int id){
        String sql = "delete from todos where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
