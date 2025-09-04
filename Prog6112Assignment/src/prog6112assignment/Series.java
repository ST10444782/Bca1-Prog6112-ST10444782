/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class Series {
    public ArrayList<SeriesClass> seriesList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);
   
    public void displayInitialScreen() {
        
        System.out.println("***************************************");
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String input = scanner.nextLine();
        if (input.equals("1")) {
            displayMenu();
        } else {
            exitSeriesApplication();
        }
    }
    
    // Displays the main menu
    public void displayMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    captureSeries();
                    break;
                case "2":
                    searchSeries();
                    break;
                case "3":
                    updateSeries();
                    break;
                case "4":
                    deleteSeries();
                    break;
                case "5":
                    seriesReport();
                    break;
                case "6":
                    exitSeriesApplication();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                exitSeriesApplication();
                break;
            }
        }
    }
    
    // Capture a new series
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");
        System.out.println("***********************");
        
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        
        String age;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            age = scanner.nextLine();
            
            if (!isValidAge(age)) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            } else {
                break;
            }
        }
        
        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes = scanner.nextLine();
        
        SeriesClass newSeries = new SeriesClass(id, name, age, episodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
    }
    
    // Validate age restriction
    boolean isValidAge(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 2 && ageValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Search for a series
    public void searchSeries() {
        System.out.print("\nEnter the series id to search: ");
        String id = scanner.nextLine();
        
        boolean found = false;
        for (SeriesClass series : seriesList) {
            if (series.seriesId.equals(id)) {
                System.out.println("---");
                System.out.println("SERIES ID: " + series.seriesId);
                System.out.println("SERIES NAME: " + series.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
                System.out.println("---");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("---");
            System.out.println("Series with Series Id: " + id + " was not found!");
            System.out.println("---");
        }
    }
    
    // Update series
    public void updateSeries() {
        System.out.print("\nEnter the series id to update: ");
        String id = scanner.nextLine();
        
        SeriesClass foundSeries = null;
        for (SeriesClass series : seriesList) {
            if (series.seriesId.equals(id)) {
                foundSeries = series;
                break;
            }
        }
        
        if (foundSeries == null) {
            System.out.println("Series with Series Id: " + id + " was not found!");
            return;
        }
        
        System.out.print("Enter the series name: ");
        foundSeries.seriesName = scanner.nextLine();
        
        String age;
        while (true) {
            System.out.print("Enter the age restriction: ");
            age = scanner.nextLine();
            
            if (!isValidAge(age)) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            } else {
                foundSeries.seriesAge = age ;
                break;
            }
        }
        
        System.out.print("Enter the number of episodes: ");
        foundSeries.seriesNumberOfEpisodes = scanner.nextLine();
        
        System.out.println("Series updated successfully!");
    }
    
    // Delete a series
    public void deleteSeries() {
        System.out.print("\nEnter the series id to delete: ");
        String id = scanner.nextLine();
        
        SeriesClass foundSeries = null;
        for (SeriesClass series : seriesList) {
            if (series.seriesId.equals(id)) {
                foundSeries = series;
                break;
            }
        }
        
        if (foundSeries == null) {
            System.out.println("Series with Series Id: " + id + " was not found!");
            return;
        }
        
        System.out.print("Are you sure you want to delete series " + foundSeries.seriesName + "? (Y/N): ");
        String confirmation = scanner.nextLine();
        
        if (confirmation.equalsIgnoreCase("Y")) {
            seriesList.remove(foundSeries);
            System.out.println("Series deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    
    // Print series report
    public void seriesReport() {
        System.out.println();
        if (seriesList.isEmpty()) {
            System.out.println("No series available to display.");
            return;
        }
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesClass series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("--- SERIES ID: " + series.seriesId);
            System.out.println("SERIES NAME: " + series.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
            System.out.println("---");
        }
    }
    
    
    public void exitSeriesApplication() {
        System.out.println("Thank you for using the Series Management Application. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}

// Refernce List


// Farrell, J.,2023. java Progamming.Boston: Cengage.
// W3Schools, 2025. Java ArrayList.[Online] Available at https://www.w3schools.com/java/java_polymorphism.asp
    

