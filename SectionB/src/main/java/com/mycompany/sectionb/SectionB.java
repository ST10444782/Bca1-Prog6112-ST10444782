/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sectionb;
import  java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class SectionB {
    
    private List<Book> books; 
    private List<User> users; 
    private int nextBookId = 1;
    private int nextUserId = 1;

    public SectionB() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        nextBookId++;
    }

    public void addUser(User user) {
        users.add(user);
        nextUserId++;
    }

    public Book findBookById(int id) {
        for (Book book : books) { 
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : users) { 
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Helps generate Report using loops and arrays
    public void generateReport() {
        System.out.println("=== Library Report ===");
        System.out.println("Total Books: " + books.size());
        int availableCount = 0;
        int borrowedCount = 0;
        int overdueCount = 0;

        System.out.println("\nBook Details:");
        for (Book book : books) { 
            System.out.println(book.getInfo());
            if (book.isAvailable()) {
                availableCount++;
            } else {
                borrowedCount++;
                if (book.isOverdue()) {
                    overdueCount++;
                }
            }
            System.out.println("Available: " + book.isAvailable() + ", Due Date: " + book.getDueDate());
            System.out.println("---");
        }

        System.out.println("\nUser Borrowing History:");
        for (User user : users) { 
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getName());
            System.out.println("Borrowed Books: " + user.getBorrowedBooks().size());
            for (Book borrowed : user.getBorrowedBooks()) {
                System.out.println("- " + borrowed.getTitle() + " (Due: " + borrowed.getDueDate() + ")");
            }
            System.out.println("---");
        }

        System.out.println("\nSummary:");
        System.out.println("Available Books: " + availableCount);
        System.out.println("Borrowed Books: " + borrowedCount);
        System.out.println("Overdue Books: " + overdueCount);
        System.out.println("=====================");
    }

    // Main menu loop
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) { // Main loop
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter type (1: Fiction, 2: Non-Fiction): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    Book book;
                    if (type == 1) {
                        System.out.print("Genre: ");
                        String genre = scanner.nextLine();
                        book = new FictionBook(nextBookId, title, author, genre);
                    } else {
                        System.out.print("Subject: ");
                        String subject = scanner.nextLine();
                        book = new NonFictionBook(nextBookId, title, author, subject);
                    }
                    addBook(book);
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    addUser(new User(nextUserId, name));
                    System.out.println("User added.");
                    break;
                case 3:
                    System.out.print("User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Book ID: ");
                    int bookId = scanner.nextInt();
                    User user = findUserById(userId);
                    Book b = findBookById(bookId);
                    if (user != null && b != null) {
                        user.borrowBook(b);
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;
                case 4:
                    System.out.print("User ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Book ID: ");
                    bookId = scanner.nextInt();
                    user = findUserById(userId);
                    b = findBookById(bookId);
                    if (user != null && b != null) {
                        user.returnBook(b);
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Invalid ID.");
                    }
                    break;
                case 5:
                    generateReport();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
    

    public static void main(String[] args) {
        SectionB library=new SectionB();
        library.run();
        
    }
}
// Refernce List

// Grok,2025. Response to Method overloading.[online] available at:https://grok.com/
// Farrell, J.,2023. java Progamming.Boston: Cengage.
// W3Schools, 2025. Java Polymorphism.[Online] Available at https://www.w3schools.com/java/java_polymorphism.asp