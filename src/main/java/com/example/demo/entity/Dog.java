package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue
    Integer id;
    String name;

    @ManyToOne
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
