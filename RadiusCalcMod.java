package com.mycompany.radiuscalcmod;

import java.util.Scanner;

public class RadiusCalcMod {

    /**
     * @param args the command line arguments
     */
    //carry out calculations or circular items
    //such as a circle, a sphere, a cone, a column
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("This program calculates round item numbers such as \n" +
                "1 - Area of a circle (pi r^2)\n" +
                "2 - Volume of a sphere (4/3 pi r^3)\n" +
                "3 - Volume of a cone (pi r^2 h/3)\n" +
                "4 - Volume of a column (pi r^2 h)");
        System.out.println("Type the number for which one you want to calculate");
        int i = s.nextInt();
        if (i == 1){
            cCalc1(s);
        }else if (i == 2){
            cCalc2(s);
        }else if(i == 3){
            cCalc3(s);
        }else if(i == 4){
            cCalc4(s);
        }
    }
    
    public static void cCalc4(Scanner s){
        System.out.println("enter the radius of your cone, then height of your cone");
        int r = s.nextInt();
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * h;
        System.out.println(result);
    }
    
    public static void cCalc3(Scanner s){
        System.out.println("enter the radius of your cone, then height of your cone");
        int r = s.nextInt();
        int h = s.nextInt();
        double result = Math.PI * Math.pow(r, 2) * (h/3.0);
        System.out.println(result);
    }
    
    public static void cCalc2(Scanner s){
        System.out.println("enter the radius of your circle");
        int r = s.nextInt();
        double result = (4.0/3.0) * Math.PI * Math.pow(r, 3);
        System.out.println(result);
    }
    
    public static void cCalc1(Scanner s){
        System.out.println("enter the radius of your circle");
        int r = s.nextInt();
        double result = Math.PI * Math.pow(r, 2);
        System.out.println(result);
    }
    
    
}