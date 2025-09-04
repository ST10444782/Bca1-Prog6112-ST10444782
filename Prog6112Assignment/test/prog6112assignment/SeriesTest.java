/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package prog6112assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;


class SeriesClass {
    String seriesId, seriesName, seriesAge, seriesNumberOfEpisodes;

    public SeriesClass(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
}

public class SeriesTest {
    private Series series;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        series = new Series();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent)); 
        
        series.seriesList.add(new SeriesClass("1", "Test Series", "12", "10"));
    }

    @Test
    public void testDisplayInitialScreen() {
        
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        series.displayInitialScreen();
        assertTrue(outContent.toString().contains("Please select one of the following menu items"));
    }

    @Test
    public void testDisplayMenu() {
        
        System.setIn(new ByteArrayInputStream("6\n".getBytes()));
        series.displayMenu();
        assertTrue(outContent.toString().contains("Thank you for using the Series Management Application"));
    }

    @Test
    public void testCaptureSeries() {
        
        String input = "2\nTest Series 2\n10\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        series.captureSeries();
        assertEquals(2, series.seriesList.size());
        assertEquals("Test Series 2", series.seriesList.get(1).seriesName);
    }

    @Test
    public void testSearchSeries() {
        
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        series.searchSeries();
        assertTrue(outContent.toString().contains("SERIES ID: 1"));
        assertTrue(outContent.toString().contains("SERIES NAME: Test Series"));
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        
        System.setIn(new ByteArrayInputStream("999\n".getBytes()));
        series.searchSeries();
        assertTrue(outContent.toString().contains("Series with Series Id: 999 was not found!"));
    }

    @Test
    public void testUpdateSeries() {
        
        System.setIn(new ByteArrayInputStream("1\nUpdated Series\n15\n20\n".getBytes()));
        series.updateSeries();
        SeriesClass updatedSeries = series.seriesList.get(0);
        assertEquals("Updated Series", updatedSeries.seriesName);
        assertEquals("15", updatedSeries.seriesAge);
        assertEquals("20", updatedSeries.seriesNumberOfEpisodes);
    }

    @Test
    public void testDeleteSeries() {
        
        System.setIn(new ByteArrayInputStream("1\nY\n".getBytes()));
        series.deleteSeries();
        assertEquals(0, series.seriesList.size());
        assertTrue(outContent.toString().contains("Series deleted successfully!"));
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
        
        System.setIn(new ByteArrayInputStream("999\n".getBytes()));
        series.deleteSeries();
        assertEquals(1, series.seriesList.size()); 
        assertTrue(outContent.toString().contains("Series with Series Id: 999 was not found!"));
    }

    @Test
    public void testSeriesReport() {
        series.seriesReport();
        assertTrue(outContent.toString().contains("Series 1"));
        assertTrue(outContent.toString().contains("SERIES NAME: Test Series"));
    }

    @Test
    public void testExitSeriesApplication() {
        series.exitSeriesApplication();
        assertTrue(outContent.toString().contains("Thank you for using the Series Management Application"));
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        
        SeriesClass seriesInstance = new SeriesClass("2", "Valid Series", "12", "10");
        assertTrue(series.isValidAge("12")); // Directly test the validation method
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        
        assertFalse(series.isValidAge("1"));  
        assertFalse(series.isValidAge("19"));
        assertFalse(series.isValidAge("abc")); 
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut); 
    }
}