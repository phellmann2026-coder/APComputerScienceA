/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gradebook;

/**
 *
 * @author PHellmann2026
 */


//public class
public class Gradebook {
    public static void main(String args[]){
        //Create students 
        Student st1 = new Student("Bob", "Smith", "Biology", "Physics", "AP Environmental Science");
        st1.setCourse1Score(85);
        st1.setCourse2Score(90);
        st1.setCourse3Score(77);
        System.out.println(st1);
        
        Student st2 = new Student("Ally", "Jones", "Biology", "Physics", "AP Environmental Science");
        st2.setCourse1Score(85);
        st2.setCourse2Score(90);
        st2.setCourse3Score(77);
        System.out.println(st2);

    }
}

//Student class with 3 courses
class Student {
    
    private String firstName, lastName;
    Course c1 = new Course();
    Course c2 = new Course(); 
    Course c3 = new Course(); 
    
    //Default constructor
    public Student(){
        firstName = "";
        lastName = "";
        c1 = new Course();
        c2 = new Course(); 
        c3 = new Course(); 
    }
    
    //Constructor to create Student object with name only
    public Student(String first, String last)
    {
        firstName = first;
        lastName = last;
        c1 = new Course(); 
        c2 = new Course(); 
        c3 = new Course(); 
    }
    
    // Constructor with 3 course NAMES
    public Student(String first, String last, String course1, String course2, String course3) {
    firstName = first;
    lastName = last;
    c1 = new Course(course1);
    c2 = new Course(course2);
    c3 = new Course(course3);
}

    
    //Constructor with 3 course objects 
    public Student(String first, String last, Course course1, Course course2, Course course3)
    {
        firstName = first;
        lastName = last;
        c1 = course1; 
        c2 = course2; 
        c3 = course3; 

    }
    
    //Setters for each course score
    public void setCourse1Score(int score){c1.setTestScore(score);}
    public void setCourse2Score(int score){c2.setTestScore(score);}
    public void setCourse3Score(int score){c3.setTestScore(score);}
    
    
    //Getters 
    public int getCourse1Score(){return c1.getTestScore();}
    public int getCourse2Score(){return c2.getTestScore();}
    public int getCourse3Score(){return c3.getTestScore();}

    
    
    //Calculate avarage 
    public double getAverage(){
        return (c1.getTestScore() + c2.getTestScore() + c3.getTestScore())/3.0;
    }
    
    
    //Provide ALL student details
    public String toString()
    {
        String result;
        result = "Student: " + firstName + " " + lastName + "\n";
        result += "Course 1: " + c1 + "\n";
        result += "Course 2: " + c2 + "\n";
        result += "Course 3: " + c3 + "\n";
        result += "Average: " + getAverage()+ "\n";
               
        return result;
    }
}

//Course class 
class Course{
    private String name;
    private int score;
    
    //initalize to zero
    public Course(){
        name = ""; 
        score = 0;
    }
    
    public Course (String name){
        this.name = name;
        this.score = 0;
    }
    
    public void setTestScore(int inScore){
        score = inScore;
    }
    
    public int getTestScore(){
        return score;
    }
    
    public String toString(){
        return name + " - Score: " + score;
    }
}