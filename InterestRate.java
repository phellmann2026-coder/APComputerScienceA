/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestrate;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author PHellmann2026
 */
public class InterestRate {

    public static void main(String[] args) {
        
        //Set up scanner
        Scanner scan = new Scanner (System.in);
        
        //Set up currency format
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        
        //Ask user for financial amount of money and set amount as object
        System.out.println("Enter loan amount: ");
        double amount = scan.nextDouble();
        
        //Ask user for number of months for repayment and ser months as object
        System.out.println("Enter number of months for repayment: ");
        int months = scan.nextInt();
        
        //Set InterestRateCalculator as a calculator
        InterestRateCalculator calc = new InterestRateCalculator(); 
       
        //Print inital amount in currency format
        System.out.println("\nInitial Amount: " + currency.format(amount));
        
        //Print interest in percent format
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(1);
        System.out.println("Interest Rate: " + percent.format(InterestRateCalculator.RATE));
        
        //Print months for repayment
        System.out.println("Repayment Period: " + months + " months\n");
        
        //Calculate repayment from InterestRateCalculator class using inputted amount and months
        calc.calculateRepayment(amount, months);
    }
}

//InterestRateCalculator class set up
class InterestRateCalculator {
    
    //Public constant for interest rate (3.5%)
    public static final double RATE = 0.035;

    //All instance variables are private
    private double totalPaid;
    private double monthlyPayment;

    //Public method will take the amount as input and then calculate the monthly payments    
    public void calculateRepayment(double amount, int months){
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        
        //Calculate base payment (dvide amount by the number of months)
        double basePayment = amount/months; 

        //Calculate monthly payment amount plus interest
        monthlyPayment = basePayment + (amount * RATE / months);

        //Calculate total amount repaid by multiplying monthly payment by number of months repaid
        totalPaid = monthlyPayment * months;

        //Output monthly payment and total amount repaid
        System.out.println("Monthly Payment (with interest): " + currency.format(monthlyPayment));
        System.out.println("Total amount paid back: " + currency.format(totalPaid));
    }            
}