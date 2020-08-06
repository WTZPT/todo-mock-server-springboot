package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dao.TodoRepository;
import com.thoughtworks.springbootemployee.dto.TodoRequest;
import com.thoughtworks.springbootemployee.dto.TodoResponse;
import com.thoughtworks.springbootemployee.model.Todo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;

@ExtendWith(SpringExtension.class)
class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Test
    @DisplayName("")
    void should_return_todos_when_getAllTodos_given_() {
        //given
        when(todoRepository.findAll()).thenReturn(getMockTodos());
        //when
        List<TodoResponse> todoResponses = todoService.getAllTodos();
        //then
        assertEquals(2,todoResponses.size());
    }

    @Test
    @DisplayName("")
    void should_return_todos_when_changeCompleteOfTodoById_given_id() {
        //given
        Todo todo = new Todo("",false);
        when(todoRepository.findById(eq(1))).thenReturn(Optional.of(todo));
        when(todoRepository.findAll()).thenReturn(getMockTodos());
        when(todoRepository.save(eq(todo))).thenReturn(new Todo());
        //when
        List<TodoResponse> todoResponses = todoService.changeCompleteOfTodoById(1);
        //then
        assertEquals(2,todoResponses.size());
    }

    @Test
    @DisplayName("")
    void should_return_todos_when_save_todo_given_todo() {
        //given
        TodoRequest todoRequest = new TodoRequest();
        todoRequest.setText("");
        when(todoRepository.findAll()).thenReturn(getMockTodos());
        when(todoRepository.save(isA(Todo.class))).thenReturn(new Todo());
        //when
        List<TodoResponse> todoResponses = todoService.createTodo(todoRequest);
        //then
        assertEquals(2,todoResponses.size());
    }

    @Test
    @DisplayName("")
    void should_validate_delete_when_deleteById_given_id() {
        //given
        when(todoRepository.findAll()).thenReturn(getMockTodos());
        //when
        todoService.deleteTodoById(1);
        //then
        verify(todoRepository).deleteById(eq(1));

    }

    private List<Todo> getMockTodos(){
        return Arrays.asList(new Todo(),new Todo());
    }

}