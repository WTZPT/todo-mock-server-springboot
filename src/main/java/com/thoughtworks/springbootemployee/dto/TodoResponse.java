package com.thoughtworks.springbootemployee.dto;

public class TodoResponse {
    private Integer id;
    private String text;
    private Boolean completed;

    public TodoResponse() {
    }

    public TodoResponse(Integer id, String text, Boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
