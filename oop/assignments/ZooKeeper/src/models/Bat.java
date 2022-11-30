package models;

public class Bat extends Mammal {

    public Bat() {
        this.setEnergyLevel(300);
    }

    public void fly() {
        System.out.println("fly");
        this.setEnergyLevel(this.getEnergyLevel() - 50);
        super.displayEnergy();
    }

    public void eatHumans() {
        System.out.println("eat");
        this.setEnergyLevel(this.getEnergyLevel() + 25);
        super.displayEnergy();
    }

    public void attackTown() {
        System.out.println("attack");
        this.setEnergyLevel(this.getEnergyLevel() - 100);
        super.displayEnergy();
    }
    
}

