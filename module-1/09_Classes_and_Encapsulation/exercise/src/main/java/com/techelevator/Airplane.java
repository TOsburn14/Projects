package com.techelevator;

public class Airplane {

            //Variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;



            //Getters

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }


    // Derived
    public int getAvailableFirstClassSeats() {
       return totalFirstClassSeats - bookedFirstClassSeats;
    }
    public int getAvailableCoachSeats(){
        return totalCoachSeats - bookedCoachSeats;
    }




            //Constructors
    public Airplane (String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }



            //Methods
    public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats){
        if (forFirstClass == true && this.getAvailableFirstClassSeats() >= totalNumberOfSeats){
            bookedFirstClassSeats += totalNumberOfSeats;
            return true;
        } else if (forFirstClass == false && this.getAvailableCoachSeats() >= totalNumberOfSeats) {
            bookedCoachSeats += totalNumberOfSeats;
            return true;
        }
        return false;

    }

}
