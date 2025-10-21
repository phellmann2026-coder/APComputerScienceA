/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.coursedetails;

/**
 *
 * @author PHellmann2026
 */

class Course {
    private String title;
    private String code;
    private int pointsTotal;
    private String instructor;
    
    //
    public Course(String inTitle, String inCode, int inPointsTotal, String inInstructor){
        title = inTitle;
        code = inCode;
        pointsTotal = inPointsTotal;
        instructor = inInstructor;
    }
    
    public Course(String inTitle){
        title = inTitle;
        code = "";
        pointsTotal = 0;
        instructor = "";
    }
        
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    
    public int getPointsTotal() {
        return pointsTotal;
    }
    public void setPointsTotal(int pointsTotal){
        this.pointsTotal = pointsTotal;
    }
    
    
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    
    
    @Override
    public String toString(){
        return "Course Title: " + title + "\n" 
                + "Course Code: " + code + "\n" 
                + "Points Total: " + pointsTotal + "\n"
                + "Instructor: " + instructor + "\n";
    }
}

public class CourseDetails {
    public static void main(String[] args) {
        Course c1 = new Course("AP Computer Science A", "3645", 5, "Dr. Nelson");
        
        Course c2 = new Course("AP Calculus BC", "2936", 5, "Mr. Dahms");
        
        Course c3 = new Course("Capstone and Practicum");
        c3.setCode("1002");
        c3.setPointsTotal(5);
        c3.setInstructor("Mr. Knoll");
        
        System.out.println("--------------Course 1: --------------\n");
        System.out.println(c1.toString());
        
        System.out.println("-------------- Course 2: --------------\n");
        System.out.println(c2.toString());
        
        System.out.println("--------------Course 3: --------------\n");
        System.out.println(c3.toString());
    }
}