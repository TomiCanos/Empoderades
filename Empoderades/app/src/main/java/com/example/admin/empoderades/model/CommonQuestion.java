package com.example.admin.empoderades.model;

public class CommonQuestion {
    private String title;
    private String content;

    public CommonQuestion() {
    }

    public CommonQuestion(String title, String content) {
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
