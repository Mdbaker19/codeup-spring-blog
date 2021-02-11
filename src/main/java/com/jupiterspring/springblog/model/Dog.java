package com.jupiterspring.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "reside_state"}))
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned")
    private long id;

    @Column(nullable = false, columnDefinition = "tinyint(3) unsigned", unique = true)
    private int age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "char(2) default 'XX'", name = "reside_state")
    private String resideState;


    public Dog(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside_state() {
        return resideState;
    }

    public void setReside_state(String resideState) {
        this.resideState = resideState;
    }
}
