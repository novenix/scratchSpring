package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
//modelo de persona
public class Person {
    private final UUID id;
    private final String name;
    //alt + enter gacer person

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
//alt + insert getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
