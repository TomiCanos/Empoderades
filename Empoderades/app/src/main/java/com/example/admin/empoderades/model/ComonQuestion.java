package com.example.admin.empoderades.model;

public class ComonQuestion {
    private String title;
    private String content;

    public ComonQuestion() {
    }

    public ComonQuestion(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
