/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.sectionb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private User user;
    private Book book;

    @BeforeEach
    public void setUp() {
        library = new Library();
        user = new User(1, "Test User");
        book = new FictionBook(1, "Test Title", "Test Author", "Fantasy");
        library.addUser(user);
        library.addBook(book);
    }

    @Test
    public void testBorrowBook() {
        user.borrowBook(book);
        assertFalse(book.isAvailable());
        assertNotNull(book.getDueDate());
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBook() {
        user.borrowBook(book);
        user.returnBook(book);
        assertTrue(book.isAvailable());
        assertNull(book.getDueDate());
        assertEquals(0, user.getBorrowedBooks().size());
    }

    @Test
    public void testOverdueBook() {
        user.borrowBook(book);
        // Simulate overdue by setting past due date
        book.setDueDate(LocalDate.now().minusDays(1));
        assertTrue(book.isOverdue());
    }

    @Test
    public void testFindBookById() {
        Book found = library.findBookById(1);
        assertNotNull(found);
        assertEquals("Test Title", found.getTitle());
    }

    @Test
    public void testInheritanceAndCategory() {
        assertInstanceOf(FictionBook.class, book);
        assertEquals("Fiction - Genre: Fantasy", book.getCategory());
    }
}