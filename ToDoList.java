/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PHellmann2026
 */
public class ToDoList {

    //Driver method instantiates to-do tasks
    public static void main(String[] args) {
        //Creates an ArrayList to store task objects
        ArrayList<Task> tasks = new ArrayList<>();

        //Instantiate task objects by name, priority and complexity 
        tasks.add(new Task("Do homework", 1, 3));
        tasks.add(new Task("Clean room", 2, 4));
        tasks.add(new Task("Go for a run", 1, 5));
        tasks.add(new Task("Walk dog", 2, 2));

        System.out.println("------TO - DO LISTER------\n");
        System.out.println("Given Tasks:\n");
        
        //Print tasks before ranking 
        for (Task t : tasks) {
            System.out.println(t);
        }
        
        //Ranks tasks in order of priority, then complexity 
        Collections.sort(tasks);

        System.out.println("\nRanked Tasks (ranked by priority, then complexity):");
        
        //Print tasks after sorting 
        for (Task t : tasks) {
            System.out.println(t);
        }
    }
}

//Interface Priority with setPriority and getPriority methods
//This allows defining a way to establish numeric priority between different object instances 
interface Priority {
    public void setPriority(int p);
    public int getPriority();
}

//Complexity interface
///This allows defining a way to establish numeric complexity between different object instances 
interface Complexity {
    public void setComplexity(int complexity);
    public int getComplexity();
}

//Task class implenments priority, complexity, and comparable interfaces 
class Task implements Priority, Complexity, Comparable <Task>{

    //Description of task
    private final String name;
    //Lower priority integer indicates higher priority 
    private int priority;
    //Lower complexity indicates easier task
    private int complexity;

    //Constructor initalizes all fields 
    public Task(String name, int priority, int complexity) {
        this.name = name;
        this.priority = priority;
        this.complexity = complexity;
    }

    // Priority interface methods
    @Override
    public void setPriority(int p) {
        priority = p;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    // Complexity interface methods
    @Override
    public void setComplexity(int c) {
        complexity = c;
    }

    @Override
    public int getComplexity() {
        return complexity;
    }

    // Comparable interface
    //Defines task ranking by ascending priority and then ascending complexity 
    @Override
    public int compareTo(Task other) {
        // First compare priority
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        }
        // If priority is equal, compare complexity
        return this.complexity - other.complexity;
    }
    
    //Return a formated string representation of each task 
    @Override
    public String toString() {
        return "- " + name + " \n    (Priority: " + priority + ", Complexity: " + complexity + ")";
    }
}