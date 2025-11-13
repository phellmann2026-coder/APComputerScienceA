/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doandforloops;

/**
 *
 * @author PHellmann2026
 */
public class DoAndForLoops {

     public static void main(String[] args)
    {
        final int MAX_ROWS = 10;
        final int HALF = 5;
        System.out.println("a.");
        //for each row
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            //print out the appropriate number of stars for that row
            for (int star = 1; star <= 11 - row; star++){
                System.out.print("*");
            }
            //newline for a new row
            System.out.println();
        }
        
        System.out.println("b.");
        //for each row
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            for (int space = 1; space <= 10 - row; space++){
                System.out.print(" ");  
            }
            
            //print out the appropriate number of stars for that row
            for (int star = 1; star <= row; star++){
                System.out.print("*");
            }
            //newline for a new row
            System.out.println();
        }
        
        System.out.println("c.");
        //for each row
        for (int row = 1; row <= MAX_ROWS; row++)
        {
            for (int space = 1; space <= row - 1; space++){
                System.out.print(" ");  
            }
            
            //print out the appropriate number of stars for that row
            for (int star = 1; star <= 11 - row; star++){
                System.out.print("*");
            }
            //newline for a new row
            System.out.println();
        }
        
        System.out.println("d.");
        //for each row
        for (int row = 1; row <= HALF; row++)
        {
            for (int space = 1; space <= 5 - row; space++){
                System.out.print(" ");  
            }
            
            //print out the appropriate number of stars for that row
            for (int star = 1; star <= 1 + (2 * (row - 1)); star++){
                System.out.print("*");
            }
            
            for (int space = 1; space <= 5 - row; space++){
                System.out.print(" ");  
            }
            
            //newline for a new row
            System.out.println();
        }
        
        for (int row = 1; row <= HALF; row++)
        {
            for (int space = 1; space <= row - 1; space++){
                System.out.print(" ");  
            }
            
            //print out the appropriate number of stars for that row
            for (int star = 1; star <= 9 - (2 * (row - 1)); star++){
                System.out.print("*");
            }
            
            for (int space = 1; space <= row - 1; space++){
                System.out.print(" ");  
            }    
            
            //newline for a new row
            System.out.println();
        }
    }
}
