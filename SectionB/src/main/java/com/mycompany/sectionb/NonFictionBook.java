/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sectionb;

import java.time.LocalDate;

/**
 *
 * @author lab_services_student
 */
public class NonFictionBook extends Book {
    private String subject;

    public NonFictionBook(int id, String title, String author, String subject) {
        super(id, title, author);
        this.subject = subject;
    }

    public NonFictionBook(int id, String title, String author, boolean available, LocalDate dueDate, String subject) {
        super(id, title, author, available, dueDate);
        this.subject = subject;
    }

    @Override
    public String getCategory() {
        return "Non-Fiction - Subject: " + subject;
    }
}

// Refernce List

// Grok,2025. Response to Method overloading.[online] available at:https://grok.com/
// Farrell, J.,2023. java Progamming.Boston: Cengage.
// W3Schools, 2025. Java Polymorphism.[Online] Available at https://www.w3schools.com/java/java_polymorphism.asp