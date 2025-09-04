/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sectionb;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author lab_services_student
 */
public abstract class Book {
    
    private int id; // Information hiding: private field
    private String title;
    private String author;
    private boolean available;
    private LocalDate dueDate;

    public Book(int id, String title, String author) {
        
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
        this.dueDate = null;
    }

    public Book(int id, String title, String author, boolean available, LocalDate dueDate) {
        
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
        this.dueDate = dueDate;
        
        
    }
    
    // Getters
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

   
    public abstract String getCategory();

    
    public boolean isOverdue() {
        if (dueDate == null) return false;
        return LocalDate.now().isAfter(dueDate);
    }

    
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        String[] details = { "ID: " + id, "Title: " + title, "Author: " + author, "Category: " + getCategory() };
        for (String detail : details) { 
            info.append(detail).append("\n");
        }
        return info.toString();
    }
}

// Refernce List

// Grok,2025. Response to Method overloading.[online] available at:https://grok.com/
// Farrell, J.,2023. java Progamming.Boston: Cengage.
// W3Schools, 2025. Java Polymorphism.[Online] Available at https://www.w3schools.com/java/java_polymorphism.asp
    
    
    
    
    
    
