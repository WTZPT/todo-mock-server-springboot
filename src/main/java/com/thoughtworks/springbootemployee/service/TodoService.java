package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dao.TodoRepository;
import com.thoughtworks.springbootemployee.dto.TodoRequest;
import com.thoughtworks.springbootemployee.dto.TodoResponse;
import com.thoughtworks.springbootemployee.exception.NoSuchDataException;
import com.thoughtworks.springbootemployee.mapper.TodoMapper;
import com.thoughtworks.springbootemployee.model.Todo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.thoughtworks.springbootemployee.mapper.TodoMapper.toTodo;
import static com.thoughtworks.springbootemployee.mapper.TodoMapper.toTodoResponse;

@Service
public class TodoService {
    @Resource
    private TodoRepository todoRepository;

    public List<TodoResponse> getAllTodos() {
        return this.todoRepository.findAll().stream()
                .map(TodoMapper::toTodoResponse)
                .collect(Collectors.toList());
    }

    public List<TodoResponse> changeCompleteOfTodoById(int id) {
        Todo todo = this.todoRepository.findById(id).orElseThrow(NoSuchDataException::new);
        todo.setCompleted(!todo.getCompleted());
        this.todoRepository.save(todo);
        return getAllTodos();
    }

    public List<TodoResponse> createTodo(TodoRequest todoRequest) {
        toTodoResponse(this.todoRepository.save(toTodo(todoRequest)));
        return getAllTodos();
    }

    public List<TodoResponse> deleteTodoById(int id) {
        this.todoRepository.deleteById(id);
        return getAllTodos();
    }
}
