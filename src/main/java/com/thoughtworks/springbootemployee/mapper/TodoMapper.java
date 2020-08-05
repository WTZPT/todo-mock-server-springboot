package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.dto.TodoResponse;
import com.thoughtworks.springbootemployee.model.Todo;

public class TodoMapper {

    public static TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getText(), todo.getCompleted());
    }
}
