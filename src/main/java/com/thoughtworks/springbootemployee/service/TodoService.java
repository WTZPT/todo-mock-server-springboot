package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dao.TodoRepository;
import com.thoughtworks.springbootemployee.dto.TodoRequest;
import com.thoughtworks.springbootemployee.dto.TodoResponse;
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

    public TodoResponse changeCompleteOfTodoById(int id) {
        Todo todo = this.todoRepository.findById(id).orElseThrow(NoClassDefFoundError::new);
        todo.setCompleted(!todo.getCompleted());
        return toTodoResponse(this.todoRepository.save(todo));
    }

    public TodoResponse createTodo(TodoRequest todoRequest) {
        return toTodoResponse(this.todoRepository.save(toTodo(todoRequest)));
    }

    public void deleteTodoById(int id) {
        this.todoRepository.deleteById(id);
    }
}
