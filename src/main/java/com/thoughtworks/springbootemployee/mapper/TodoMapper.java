package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.dto.TodoRequest;
import com.thoughtworks.springbootemployee.dto.TodoResponse;
import com.thoughtworks.springbootemployee.model.Todo;

public class TodoMapper {

    public static TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getText(), todo.getCompleted());
    }

    public static Todo toTodo(TodoRequest todoRequest) {
        return new Todo(todoRequest.getText(),false);
    }
}
