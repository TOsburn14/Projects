package com.techelevator.farm;

public class FarmAnimal {

    private String name;
    private String sound;

    public FarmAnimal(String name, String sound) {
        this.name = name;
        this.name = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "The " + getName() + " says " + getSound();
    }
}
