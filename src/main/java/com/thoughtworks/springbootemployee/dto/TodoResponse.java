package com.thoughtworks.springbootemployee.dto;

public class TodoResponse {
    private Integer id;
    private String content;
    private Boolean completed;

    public TodoResponse() {
    }

    public TodoResponse(Integer id, String content, Boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
