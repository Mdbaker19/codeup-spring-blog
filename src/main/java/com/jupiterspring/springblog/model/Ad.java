package com.jupiterspring.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key, auto increment
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String description;

    public Ad(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
