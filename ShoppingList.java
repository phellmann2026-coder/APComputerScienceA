/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppinglist;

/**
 *
 * @author PHellmann2026
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        
        // Add items
        System.out.println("Enter items (type 'done' to finish):");
        while (true) {
            String item = sc.nextLine().trim();
            if (item.equalsIgnoreCase("done")) break;
            if (!item.isEmpty()) {
                list.add(item);
            }
        }
        
        // Check if list is empty
        if (list.isEmpty()) {
            System.out.println("No items added!");
            sc.close();
            return;
        }
        
        // Display list
        System.out.println("\nShopping List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        
        // Remove items loop
        while (!list.isEmpty()) {
            System.out.print("\nRemove an item? (yes/no): ");
            String answer = sc.nextLine().trim();
            
            if (answer.equalsIgnoreCase("no")) break;
            
            if (!answer.equalsIgnoreCase("yes")) {
                System.out.println("Please enter 'yes' or 'no'");
                continue;
            }
            
            System.out.print("Remove item number: ");
            String input = sc.nextLine().trim();
            
            try {
                int num = Integer.parseInt(input);
                
                if (num < 1 || num > list.size()) {
                    System.out.println("Invalid number! Choose between 1 and " + list.size());
                    continue;
                }
                
                String removed = list.remove(num - 1);
                System.out.println("Removed: " + removed);
                
                // Display updated list
                if (!list.isEmpty()) {
                    System.out.println("\nUpdated List:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i));
                    }
                } else {
                    System.out.println("\nList is now empty!");
                    break;
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        
        sc.close();
    }
}

