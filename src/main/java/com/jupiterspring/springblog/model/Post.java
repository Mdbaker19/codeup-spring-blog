package com.jupiterspring.springblog.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(columnDefinition = "varchar(100) default 'Unknown'")
    private String author;

    @Column(nullable = false)
    private Date date;

    public Post(){}

    public Post(long id, String a, String t, String b, Date d){
        this.id = id;
        this.author = a;
        this.title = t;
        this.body = b;
        this.date = d;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
