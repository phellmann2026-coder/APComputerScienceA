/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.classinheritance;

/**
 *
 * @author PHellmann2026
 */


public class ClassInheritance {

    public static void main(String[] args) {
        
        Vehicle[] vehicles = {
           //Cars: 
            new ElectricCar(), 
            new RaceCar(),
           //Boats 
            new Yacht(),
            new JetSki(), 
           //Planes
            new Boeing(), 
            new FighterJet(), 
           //Others
            new Submarine(),
            new Rover(), 
        };
        
        //Loop through vehicles 
        for (Vehicle v : vehicles){
            System.out.println(v);
            System.out.println("-----------------------------------------");
        }
    }
}

// The Base Vehicle Class, implements the Speedometer interface
class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;
    //Base default constructor 
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
        cargoWeight = 0.0;
    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    //getters and setters
    public Vehicle(String inBrand){
        brandName = inBrand;
    }

    public String getBrand(){
        return brandName;
    }

    public  void setBrandName(String inBrand){
        brandName = inBrand;
    }

    public double getSpeed(){
        return  speed;
    }

    public void setSpeed(double inSpeed){
        speed = inSpeed;
    }

    public int getPassengers(){
        return  passengers;
    }

    public void setPassengers(int inPassengers){
        passengers = inPassengers;
    }

    public double getCargoWeight(){
        return  cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight){
        cargoWeight = inCargoWeight;
    }

    //Base toString
    public String toString(){
        String result = "";
        result = "Brand: \t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
    void setSpeed(double inSpeed);
    double getSpeed();
 }

//Boat #1: 
//Speed is stored in mph but converted to knots
class Yacht extends Vehicle { 
    //How deep the boat sits in the water 
    private double draftDepth; 
    
    public Yacht (){
        super("Sunseeker Predator", 40.0, 12, 83000.0);
        this.draftDepth = 5.2;
    }
    
    //Convert MPH to Knots (Boat speed is measured in Knots not MPH)\
    public double getSpeedInKnots(){
        return getSpeed() * 0.868976;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Draft Depth: \t" + draftDepth + "ft\n" + "Speed (Knots): \t" + getSpeedInKnots();
        
    }
    
}

//Boat #2: 
class JetSki extends Vehicle { 
    //How deep the boat sits in the water 
    private double draftDepth; 
    
    public JetSki (){
        super("Sea-Doo GTX", 70.0, 3, 600.0);
        this.draftDepth = 1.0;
    }
    
    //Convert MPH to Knots (Boat speed is measured in Knots not MPH)\
    public double getSpeedInKnots(){
        return getSpeed() * 0.868976;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Draft Depth: \t" + draftDepth + "ft\n" + "Speed (Knots): \t" + getSpeedInKnots();
        
    }
    
}

//Airplane #1:
class Boeing extends Vehicle { 
    //Maximum altitude plane can travel
    private int maxAltitude; 
    
    public Boeing(){ 
        super("Boeing 747", 570.0, 524, 735000.0);
        this.maxAltitude = 35000; 
    }
    
    @Override
    public String toString(){
        return  super.toString() + "Max Altitude: \t" + maxAltitude + "ft";
    }
}

//Airplane #2: 
class FighterJet extends Vehicle { 
    private int maxAltitude; 
    
    public FighterJet(){ 
        super("F-22 Raptor", 1500.0, 1, 83500.0);
        this.maxAltitude = 60000; 
    }
    
    @Override
    public String toString(){
        return  super.toString() + "Max Altitude: \t" + maxAltitude + "ft";
    }
}

// Car Class inherits from Vehicle Class
class Car extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setSpoiler(boolean inSpoiler){
        spoiler = inSpoiler;
    }

    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
    public void setStereo(boolean inStereo){
        stereo = inStereo;
    }

    public boolean getStereo(){
        return  stereo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "MPG : \t \t" + this.getMPG();
        return  result ;
    }
}

//Car #1: 
class ElectricCar extends Car { 
    //Battery level of car
    private double batteryLevel = 100.0; 
    
    public ElectricCar(){
        //Call Car constructor 
        super("Tesla Model S", 120.0, 5, 500.0, 130.0);
        this.batteryLevel = 92.0;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nBattery Level: \t" + batteryLevel + "%";
        
    }
}

//Car #2:
class RaceCar extends Car { 
    //Number of pit stops required per race
    private double pitStopCount; 
    
    public RaceCar(){
        //Call Car constructor 
        super("Ferrari", 211.0, 2, 70.0, 18.0);
        this.pitStopCount = 2;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nPit Stop Count: " + pitStopCount; 
        
    }
}

//Other #1: 
class Submarine extends Vehicle {
    //Maximum depth sub can travel 
    private int maxDepth;
    
    public Submarine() {
        super("U.S. Navy Virginia-Class", 25.0, 135, 200000.0);
        this.maxDepth = 800;
    }
    
    public double getSpeedInKnots(){
        return getSpeed() * 0.868976;
    }
    
    @Override 
    public String toString(){
        return super.toString() + "Max Depth (ft): \t" + maxDepth + "\n" + "Speed (Knots): \t" + getSpeedInKnots();
    }
}

//Other #2: 
class Rover extends Vehicle {
    //Number of cameras on rover
    private int cameraCount;
    
    public Rover() {
        super("NASA Perseverance", 0.1, 0, 2260.0);
        this.cameraCount = 23;
    }
    
    @Override 
    public String toString(){
        return super.toString() + "Camera Count: \t" + cameraCount;
    }
}
