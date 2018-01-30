package com.newton.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "name")
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    protected Author() {}

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Author[id=%d, name='%s']", id, name);
    }

    // Setters and getters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}