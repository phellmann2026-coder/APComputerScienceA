/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.leapyearsolution;

import java.util.Scanner;

/**
 *
 * @author PHellmann2026
 */
public class LeapYearSolution {

    public static void main(String[] args) {
        //Set up scanner
        Scanner scan = new Scanner (System.in);
        
        //Ask user for year
        System.out.println("Enter year: ");
        
        //Read integer value from user and set integer as "year"
        int year = scan.nextInt ();
        
        //Set up a boolean variable isLeapyear and initialize as false
        boolean isLeapyear = false;
        
        //Produce an error message for any value less than 1582
        if (year < 1582){
            System.out.println("ERROR: Year must be 1582 or later");
            return;
        }
        
        //If year is divisable by four and 100 OR divisable by 400, it is a leap year. Set boolean variable as true if year is a leap year.
        if ((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0)) {
            isLeapyear = true;
        }
        
        //If boolean variable is true, print message to user identifying that the inputted year is a leap year. If else, print message that the inputted year is not a leap year. 
        if (isLeapyear){
            System.out.println("\n" + year + " is a leap year");
        }else {
            System.out.println("\n" + year + " is not a leap year");
        }
        
    }
}
