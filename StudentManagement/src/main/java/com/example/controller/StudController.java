package com.example.controller;  // Change package name

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.entity.Student;

@RestController
@RequestMapping("/studData")
@CrossOrigin("*")
public class StudController {

    private Map<Long, Student> studentEntry = new HashMap<>();

    // Default endpoint to test API is running
    @GetMapping
    public String welcomeMessage() {
        return "Welcome to the Student Management API!";
    }

    // Health check
    @GetMapping("/abc")
    public String healthCheck() {
        return "Site is Working";
    }

    // Get all students
    @GetMapping("/xyz")
    public List<Student> getAll() {
        return new ArrayList<>(studentEntry.values());
    }

    // Add student
    @PostMapping("/add")
    public String createEntry(@RequestBody Student myEntry) {
        if (myEntry.getId() == null) {
            return "Error: ID cannot be null!";
        }
        studentEntry.put(myEntry.getId(), myEntry);
        return "Student added successfully!";
    }

    // Get student by ID
    @GetMapping("/id/{myId}")
    public Student getStudentById(@PathVariable Long myId) {
        return studentEntry.get(myId);
    }

    // Delete student
    @DeleteMapping("/id/{myId}")
    public String deleteStudentById(@PathVariable Long myId) {
        return studentEntry.remove(myId) != null ? "Student deleted!" : "Error: Student not found!";
    }

    // Update student
    @PutMapping("/id/{id}")
    public String updateStudentById(@PathVariable Long id, @RequestBody Student myEntry) {
        if (!studentEntry.containsKey(id)) {
            return "Error: Student not found!";
        }
        studentEntry.put(id, myEntry);
        return "Student updated successfully!";
    }
}
