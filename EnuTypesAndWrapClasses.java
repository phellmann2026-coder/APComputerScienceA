/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.enutypesandwrapclasses;

import java.util.Scanner;

/**
 *
 * @author PHellmann2026
 */
public class EnuTypesAndWrapClasses {
    enum Weekdays {Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
    enum Months {January, Febuary, March, April, May, June, July, August, September, October, November, December};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
    //Part 1A
        Weekdays mon, tues, wed, thurs, fri, sat, sun;
        mon = Weekdays.Monday;
        tues = Weekdays.Tuesday;
        wed = Weekdays.Wednesday;
        thurs = Weekdays.Thursday;
        fri = Weekdays.Friday;
        sat = Weekdays.Saturday;
        sun = Weekdays.Sunday;
        
        System.out.println();
        System.out.println("Days of Week (1-7): ");
        for (Weekdays day : Weekdays.values()){
            System.out.println(day + ": " + (day.ordinal() + 1));
        }
        
    //Part 1B
        Months jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;
        jan = Months.January; 
        feb = Months.Febuary;
        mar = Months.March;
        apr = Months.April;
        may = Months.May; 
        jun = Months.June;
        jul = Months.July;
        aug = Months.August; 
        sep = Months.September;
        oct = Months.October;
        nov = Months.November;
        dec = Months.December;
        
        System.out.println();
        System.out.println("Months of Year (1-12): ");
        for (Months month : Months.values()){
            System.out.println(month + ": " + (month.ordinal() + 1));
        }
             
    
    
    //Part 2
        System.out.println();       
        System.out.println("Enter CCHS uername: ");
        String username = scan.nextLine();
        String year = username.substring(username.length()-4);
        int gradYear = Integer.parseInt(year);
        int nextYear = gradYear +1;
        String binaryYear = Integer.toBinaryString(gradYear);
        
        System.out.println();
        System.out.println("Graduation year: " + gradYear);
        System.out.println("Year after graduation: " + nextYear);
        System.out.println("In computer language you graduate in: " + binaryYear);
        
        
    }
}
