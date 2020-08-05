package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.common.JsonResult;
import com.thoughtworks.springbootemployee.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.thoughtworks.springbootemployee.common.JsonResult.success;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public JsonResult getAllTodo(){
        return success(todoService.getAllTodos());
    }
}
