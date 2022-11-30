package com.brian.zookeeper.models;

public class Gorilla extends Mammal {
   
    public Gorilla() {}

    public void throwSomething() {
        System.out.println("gorilla mad. gorilla throw.");
        this.setEnergyLevel(this.getEnergyLevel() - 5);
        super.displayEnergy();
    }

    public void eatBananas() {
        System.out.println("gorilla hungry. gorilla eat.");
        this.setEnergyLevel(this.getEnergyLevel() + 10);
        super.displayEnergy();
    }

    public void climb() {
        System.out.println("gorilla bored. gorilla climb.");
        this.setEnergyLevel(this.getEnergyLevel() - 10);
        super.displayEnergy();
    }
}
