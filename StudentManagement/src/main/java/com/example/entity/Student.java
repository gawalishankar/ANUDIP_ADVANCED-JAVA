package com.example.entity;  // Change package name

public class Student {
    private Long id;   // Change int to Long
    private String name;  // Variable names should start with lowercase
    private String rollCall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getrollCall() {
        return rollCall;
    }

    public void setrollCall(String rollCall) {
        this.rollCall = rollCall;
    }
}
