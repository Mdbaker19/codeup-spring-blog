package com.jupiterspring.springblog.model;

public class Post {

    private long id;
    private String title;
    private String body;

    public Post(){}

    public Post(long id, String t, String b){
        this.id = id;
        this.title = t;
        this.body = b;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
