package models;

public class Mammal {

    private int energyLevel;
    
    public Mammal() {
        this.setEnergyLevel(100);
    }

    public int getEnergyLevel() {
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    //methods 
    public void displayEnergy() {
        System.out.println("Energy level: " + this.getEnergyLevel()); 
    }

}