package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dao.TodoRepository;
import com.thoughtworks.springbootemployee.dto.TodoResponse;
import com.thoughtworks.springbootemployee.mapper.TodoMapper;
import com.thoughtworks.springbootemployee.model.Todo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.thoughtworks.springbootemployee.mapper.TodoMapper.toTodoResponse;

@Service
public class TodoService {
    @Resource
    private TodoRepository todoRepository;

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(TodoMapper::toTodoResponse)
                .collect(Collectors.toList());
    }

    public TodoResponse changeCompleteOfTodoById(int id) {
        Todo todo = todoRepository.findById(id).orElseThrow(NoClassDefFoundError::new);
        todo.setCompleted(!todo.getCompleted());
        return toTodoResponse(todoRepository.save(todo));
    }

}
