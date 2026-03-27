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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class ReadWriteAntFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.println("Enter graduation year");
        String grad = scanner.nextLine(); 
        
        System.out.println("Enter username");
        String user = scanner.nextLine();
        
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter shortFormatter = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.US); // Explicitly setting to US locale form consistent example
        
        // Format the LocalDateTime to a string
        String formattedDateTime = now.format(shortFormatter);
        String filePath = "Contacts/ContactList.txt";
        String outPath = "Contacts/ContactList.txt";
        String contentToWrite = name 
                + ", " + email 
                + ", " + grad
                + ", " + user + "\n";
        
        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            //writer.write(contentToWrite);
            writer.append(contentToWrite + "\n");
            System.out.println("Successfully wrote to the file." + formattedDateTime);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
        
        // Read from file
        try (BufferedReader reader = new BufferedReader(new FileReader(outPath))) {
            String line;
            System.out.println("\nReading from the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);   
            }
        } catch (IOException e) {
        System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}