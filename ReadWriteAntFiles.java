/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PHellmann2026
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class ReadWriteAntFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();
        
        String filePath = "Contacts/ContactList.txt";
        
       
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String email = parts[1].trim();
                    int grad = Integer.parseInt(parts[2].trim());
                    String user = parts[3].trim();

                    contacts.add(new Contact(name, email, grad, user));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found.");
        }
        
        while(true) { 
            System.out.println("\nWelcome to the contact book!"
                    + "\n- To add a contact, enter a"
                    + "\n- To order contacts by email address, enter e"
                    + "\n- To order contacts by graduation year, enter y"
                    + "\n- To order contacts by name, enter n");
            char command = scanner.nextLine().toLowerCase().charAt(0);

            if (command == 'a'){
                System.out.println("Enter name: ");
                String name = scanner.nextLine();

                System.out.println("Enter email: ");
                String email = scanner.nextLine();

                System.out.println("Enter graduation year");
                int grad = scanner.nextInt(); 
                scanner.nextLine();

                System.out.println("Enter username");
                String user = scanner.nextLine();

                Contact newContact = new Contact(name, email, grad, user);
                contacts.add(newContact);

                // Write to file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                    writer.write(newContact.toString());
                    writer.newLine();
                    System.out.println("Contact saved.");
                } catch (IOException e) {
                    System.err.println("An error occurred while writing to the file: " + e.getMessage());
                }
            } 

            if (command == 'e'){
                contacts.sort(Comparator.comparing(c -> c.email));
            }else if (command == 'y'){
                contacts.sort(Comparator.comparingInt(c -> c.grad));
            }else if (command == 'n'){
                contacts.sort(Comparator.comparing(c -> c.name));
            }

            System.out.println("\nContacts: ");
            for (Contact c : contacts){
                System.out.println(c);
            }
        }
    } 
  
    
    static class Contact { 
        String name; 
        String email; 
        int grad; 
        String user; 
        
        public Contact(String name, String email, int grad, String username){ 
            this.name = name; 
            this.email = email; 
            this.grad = grad; 
            this.user = username; 
        }
        
        @Override
        public String toString(){
            return name + ", " + email + ", " + grad + ", " + user; 
        }
    }
}
