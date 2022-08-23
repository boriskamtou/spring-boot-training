package com.boris.dogapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {
    private String name;
    private String breed;
    private String origin;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Dog() {
    }

    public Dog(String name, String breed, String origin, Long id) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
        this.id = id;
    }

    public Dog(String name, String breed, String origin) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
