/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sectionb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lab_services_student
 */
public class User {
    
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        
    }
    
    // Getters
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            book.setDueDate(LocalDate.now().plusDays(14)); 
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            book.setDueDate(null);
        }
    }
}
    
// Refernce List

// Grok,2025. Response to Method overloading.[online] available at:https://grok.com/
// Farrell, J.,2023. java Progamming.Boston: Cengage.
// W3Schools, 2025. Java Polymorphism.[Online] Available at https://www.w3schools.com/java/java_polymorphism.asp
    
    
    
    
    

