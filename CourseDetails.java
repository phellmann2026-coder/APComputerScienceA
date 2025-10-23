/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.coursedetails;

/**
 *
 * @author PHellmann2026
 */

class Course {
    //Instance data that represents the course title, course code, pointsTotal, and course Instructor's name
    private String title;
    private String code;
    private int pointsTotal;
    private String instructor;
    
    //Course constructor to accept and initialize all instance data
    public Course(String inTitle, String inCode, int inPointsTotal, String inInstructor){
        title = inTitle;
        code = inCode;
        pointsTotal = inPointsTotal;
        instructor = inInstructor;
    }
    
    //Course constructor which accepts course name only
    public Course(String inTitle){
        title = inTitle;
        code = "";
        pointsTotal = 0;
        instructor = "";
    }
    
    //Accessor and mutator methods for course title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    //Accessor and mutator methods for course code
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    //Accessor and mutator methods for course points total
    public int getPointsTotal() {
        return pointsTotal;
    }
    public void setPointsTotal(int pointsTotal){
        this.pointsTotal = pointsTotal;
    }
    
    //Accessor and mutator methods for course instructor
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    
    //toString method that returns a multiline description of the course
    @Override
    public String toString(){
        return "Course Title: " + title + "\n" 
                + "Course Code: " + code + "\n" 
                + "Points Total: " + pointsTotal + "\n"
                + "Instructor: " + instructor + "\n";
    }
}

//Driver class
public class CourseDetails {
    public static void main(String[] args) {
        //Instantiate and update course 1 using the full object constructor 
        Course c1 = new Course("AP Computer Science A", "3645", 5, "Dr. Nelson");
        
        //Instantiate and update course 2 using the full object constructor 
        Course c2 = new Course("AP Calculus BC", "2936", 5, "Mr. Dahms");
        
        //Instantiate and update course 3 using the name only creator
        Course c3 = new Course("Capstone and Practicum");
        c3.setCode("1002");
        c3.setPointsTotal(5);
        c3.setInstructor("Mr. Knoll");
        
        //Print out each course from toString
        System.out.println("Course 1: \n");
        System.out.println(c1.toString());
        
        System.out.println("Course 2: \n");
        System.out.println(c2.toString());
        
        System.out.println("Course 3: \n");
        System.out.println(c3.toString());
    }
}
