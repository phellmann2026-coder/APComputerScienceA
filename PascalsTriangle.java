/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascalstriangle;
import java.util.Scanner;

/**
 *
 * @author PHellmann2026
 */


public class PascalsTriangle {

    // Recursive function
    public static int pascalValue(int n, int k) {
        // Base cases
        if (k == 0 || k == n) {
            return 1;
        }

        // Recursive step
        return pascalValue(n - 1, k - 1) + pascalValue(n - 1, k);
    }

    // Print the entire "n" row of Pascal's Triangle using an array to store the values on each line
    public static void printRow(int n) {
        int[] row = new int[n + 1];
        
        for (int k = 0; k <= n; k++) {
            row[k] = pascalValue(n, k);
        }
        
        //Print the array 
        for (int value : row){ 
            System.out.print(value + " ");
        }
        System.out.println();
    }

    
    // Main method to run and print results 
    public static void main(String[] args) {
        //Ask user what row they wish to see
        Scanner scan = new Scanner(System.in);
        System.out.println("What row of Pascal's Triangle would you like to see?");
        
        //Set "n" as inputed value
        int n = scan.nextInt();
   
        //Print results 
        System.out.println("Row " + n + " of Pascal's Triangle:");
        printRow(n);
    }
}
