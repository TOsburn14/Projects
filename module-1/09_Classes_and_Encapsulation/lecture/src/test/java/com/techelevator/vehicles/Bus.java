package com.techelevator.vehicles;

public class Bus {

    /*
    Constant (Static Final) variables allow for more readable code
     */

    private static final int TOTAL_SEATS = 40;
    private static final int MAX_GALLONS_OF_GAS = 100;

    //Member Variables - Also called Instance Variables
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
    Constructors create the class when new keyword is used
    Constructors are special methods that always have the same name as
    the class and never have return type
     */
    /*
    The default no-argument is implicit in the class if no other constructors
    are present. If constructor overloads are added then the no-argument
    constructor must be explicitly added if its wanted
     */
    public Bus(){

    }

    public Bus(String routeName){
        this.routeName = formatRouteName(routeName);
    }


   /*
        Getters & Setters
        Getters - Retrieve and return values of a private member variable
        Setters - Set the value of a private member variable
    */

    public String getRouteName() {
        return routeName;
    }

    public int getPassengers(){
        return passengers;
    }
    public int getGallonsOfGas(){
        return gallonsOfGas;
    }
    public boolean isDoorOpen(){
        return isDoorOpen;
    }

    public void setRouteName(String routeName){
        this.routeName = formatRouteName(routeName);
    }
    /*
    Encapsulated Getters and Setters present the functionality in a more
    intuitive way
     */
    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    /*
    Derived Property
    Calculates a value based on the other properties and returns it, but never stores it.
     */

    public int getRemainingSeats () {
        return TOTAL_SEATS - this.passengers;
    }

    /*
    Public Methods provide behavior for the data type
     */
    public int addGas(int gallonsToAdd){
        if (this.gallonsOfGas + gallonsToAdd <= 100){
            this.gallonsOfGas += gallonsToAdd;
        }
        return this.gallonsOfGas;
    }

    /*
    Methods can have overloads/ Overload is a method with the same access
    return type and name but a different number, data type, or parameters
     */
    public boolean board() {
        // Door must be open
        //Must have 1 or more remaining seats
        if (this.isDoorOpen == true && getRemainingSeats() > 0) {
            this.passengers++;
            return true;
        }
        return false;
    }
    public boolean board(int numberOfBoardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= numberOfBoardingPassengers){
            this.passengers += numberOfBoardingPassengers;
            return true;
        }
        return false;
    }
    /*
    private methods are for code organization and usability in the class
    and not available for anyone else
     */
    private String formatRouteName(String routeName){
        String formattedRouteName = routeName.toUpperCase().replaceAll("","-");
        return formattedRouteName;
    }


}
