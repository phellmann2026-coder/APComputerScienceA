/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wordlegamefinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PHellmann2026
 */

public class WordleGameFinal {

    //Display menu and handle overall program loop
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        
        //Display welcome message
        System.out.println("""
                           Welcome to **WORDLE**
                           
                           Rules: 
                           - You have six guesses to find a 5 letter secret word
                           - "-" means the correct letter in the correct place 
                           - "O" means the letter is in the word but in the wrong place
                           - "X" means the letter is not in the word 
                           
                           Press return to begin""");
        
        //Waits for user to press enter 
        scan.nextLine();

        //Main menu loop
        while (running) {
            //Show main menu choices
            displayMainMenu();
            
            System.out.println("Enter your choice (1-3): ");
            String choice = scan.nextLine().trim();

            //Check user choice
            switch (choice) {
                //Begin Wordle game
                case "1" -> {
                    startGame(scan);
                    break;    
                }
                //Display rules
                case "2" -> {
                    showRules(scan);
                    break;
                }
                //Quit program
                case "3" -> {
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                }
                default -> {
                    System.out.println("\nINVALID INPUT. Please input 1, 2, or 3\n");
                } 
            }
        }
    }
    
    //Display main menu options
    public static void displayMainMenu(){
        System.out.println("""
                               == Main menu ==
                               1. Start New Game
                               2. View Rules
                               3. Quit Program 
                               """);
    }
    
    //Display game rules
    public static void showRules(Scanner scan) {
    System.out.println("""
                       == Rules ==
                       - You have six guesses to find a 5 letter secret word
                       - "-" means the correct letter in the correct place 
                       - "O" means the letter is in the word but in the wrong place
                       - "X" means the letter is not in the word 
                       
                       Press ENTER to return to the main menu """);
   
    //Pause, wait for use to press enter 
    scan.nextLine();
    }
    
    //Runs one full Wordle game session
    public static void startGame(Scanner scan) {
    System.out.println("\nLets begin...");

    //List of possible secret words
    ArrayList<String> wordBank = new ArrayList<>();
    wordBank.add("stain");
    wordBank.add("train");
    wordBank.add("tease");
    wordBank.add("house");
    wordBank.add("plane");
    wordBank.add("brush");
    wordBank.add("apple");
    wordBank.add("green");
    wordBank.add("hunch");
    wordBank.add("fiber");
    wordBank.add("piper");
    wordBank.add("lying");
    wordBank.add("hitch");
    wordBank.add("guess");
    wordBank.add("tulip");
    wordBank.add("ninth");
    wordBank.add("knoll");
    wordBank.add("cynic");
    wordBank.add("shrug"); 
    wordBank.add("ghoul"); 
    wordBank.add("pixel"); 
    
    Random random = new Random(); 
    //Pick random word
    String secretWord = wordBank.get(random.nextInt(wordBank.size()));
    
    int guessNumber = 1;
    //Track whether the player guessed correctly
    boolean won = false;
          
    //Loop for six guesses
    while (guessNumber <= 6){
        System.out.println("\nGuess " + guessNumber+ " of 6:");
        System.out.print("Enter a 5 letter word: ");
        String guess = scan.nextLine().trim().toLowerCase();
        
        //Check if guess is valid
        if (!validateInput(guess)){
            System.out.println("\nInvalid guess. Must be exactly 5 letters. No other characters or numbers.");
            continue; //Do not count this as a used guess
        }
        
        //Create feedback string (-, O, X)
        String feedback = generateFeedback(guess, secretWord);
        System.out.println("Result: " + feedback);
        
        //Check for win
        if (guess.equals(secretWord)){
            System.out.println("\nCongratulations! You guessed the word!\n");
            won = true;
            break;
        }
        
        //Warn player before last guess
        if (guessNumber == 5){
            System.out.println("\n!! Last guess coming up! Make it count!");
        }
        
        //Move to next guess
        guessNumber++;
    } 
    
    //If player does not win after six guesses
    if (!won){
        System.out.println("\nSorry you ran out of guesses. The word was " + secretWord + "\n");
        
        //Game over menu 
        while (true) {
            System.out.println("""
                    == Game Over ==
                    1. Play Again
                    2. View Rules
                    3. Quit Program
                    """);
            System.out.print("Enter choice: ");
            String choice = scan.nextLine().trim();

            switch (choice) {
                //Restart new game
                case "1" -> {startGame(scan); break;}
                //Redisplay rules
                case "2" -> {showRules(scan); break;}
                //Quit program
                case "3" -> System.exit(0);
                default -> System.out.println("\nINVALID INPUT. Please input 1, 2, or 3\n");
            }
        }
      }
    }
    
    //Ensure guess has five letters
    public static boolean validateInput(String guess) {
        //Must be five letters
        if (guess.length() != 5) return false; 
        
        //Ensure each character is alphabetic
        for (int i = 0; i < guess.length(); i++){
            if (!Character.isLetter(guess.charAt(i))) return false;
        }
        return true;
    }
    
    //Return feedback for each letter (-, O, X)
    public static String generateFeedback(String guess, String secretWord){
        StringBuilder feedback = new StringBuilder();
        
        //Check each letter in guess
        for (int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            
            //Correct spot
            if(g == secretWord.charAt(i)){
                feedback.append("- ");
            }
            //Wrong place but exists
            else if (secretWord.indexOf(g) !=-1){
                feedback.append("O ");
            }
            //Not in word 
            else{
                feedback.append("X ");
            }
        }
        return feedback.toString();
    }
}