/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.weekdays;

/**
 *
 * @author PHellmann2026
 */

public class Weekdays {

    public static void main(String[] args) {
        
        // Write out an initialized array "weekDays" with all 7 days of the week.
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        // Print the days of the week out, one day per row
        System.out.println("All days:");
        for (String day : weekDays) {
            System.out.println(day);
        }

        // RESIZING: for just the weekdays
        // Create a new array of size 5 and copy only the weekdays
        String[] weekDaysShort = new String[5];
        System.arraycopy(weekDays, 0, weekDaysShort, 0, 5);

        // Print the resized array, one day per row
        System.out.println("\nWeekdays Only:");
        for (String day : weekDaysShort) {
            System.out.println(day);
        }
        
        // Shuffle the weekdays
        shuffle(weekDaysShort); 
        
        // Print the shuffled weekdays
        System.out.println("\nShuffled Weekdays:");
        for (String day : weekDaysShort) { 
            System.out.println(day);
        }
    }

    // Shuffle method
    public static void shuffle(String[] array) {
        for (int i = 0; i < array.length; i++) { 
            int randomIndex = (int)(Math.random() * array.length);

            String temp = array[i];
            array[i] = array[randomIndex]; 
            array[randomIndex] = temp;
        } 
    }
}
