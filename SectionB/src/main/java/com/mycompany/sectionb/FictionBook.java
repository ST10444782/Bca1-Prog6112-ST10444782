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
public class FictionBook extends Book {
    private String genre;

    public FictionBook(int id, String title, String author, String genre) {
        super(id, title, author);
        this.genre = genre;
    }

    public FictionBook(int id, String title, String author, boolean available, LocalDate dueDate, String genre) {
        super(id, title, author, available, dueDate);
        this.genre = genre;
    }

    @Override
    public String getCategory() {
        return "Fiction - Genre: " + genre;
    }
}