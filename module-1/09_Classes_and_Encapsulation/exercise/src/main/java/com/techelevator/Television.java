package com.techelevator;

public class Television {

    //Member Variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;
    private static final int MAX_TV_VOLUME = 10;
    private static final int LOWEST_TV_VOLUME = 0;

    //Constructors not needed

    //Getters
    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }


    //Methods
    public void turnOff(){
        this.isOn = false;
    }
    public void turnOn(){
        this.isOn = true;
    }
    public void changeChannel(int newChannel){
        if (this.isOn == true && newChannel >= 3 && newChannel <= 18){
            this.currentChannel=newChannel;
        }
    }
    public void channelUp(){
        if (this.isOn == true){
            currentChannel++;
            if (currentChannel > 18){
                currentChannel = 3;
            }
        }
    }
    public void channelDown(){
        if (this.isOn == true){
            currentChannel--;
            if (currentChannel < 3){
                currentChannel = 18;
            }
        }
    }
    public void raiseVolume(){
        if (this.isOn == true && currentVolume < MAX_TV_VOLUME){
            currentVolume++;

        }
    }
    public void lowerVolume(){
        if (this.isOn == true && currentVolume > LOWEST_TV_VOLUME){
            currentVolume--;
        }
    }
}
