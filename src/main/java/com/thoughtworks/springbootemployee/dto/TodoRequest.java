package com.thoughtworks.springbootemployee.dto;

public class TodoRequest {
    private String text;


    public TodoRequest() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
