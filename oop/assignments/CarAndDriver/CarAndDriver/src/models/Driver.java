package models;

public class Driver extends Car{

    public void reFuel() {
        if (this.getGas() < 8) {
            this.setGas(this.getGas() + 2);
            System.out.println("Re-fueled");
            System.out.println("your gas level is now " + this.getGas());
        } else {
            System.out.println("No need to re-fuel");
        }
    }

    public void drive() {
        if (this.getGas() > 0) {
            this.setGas(this.getGas() -1);
            System.out.println("Driving");
            System.out.println("your gas level is " + this.getGas());
        } else {
            System.out.println("Out of gas");
        }
    }

    public void useBoost() {
        if (this.getGas() < 3) {
            System.out.println("no boost for you");
        } else {
            this.setGas(this.getGas() -3);
            System.out.println("BOOOOSTED");
            System.out.println("you gas level is " + this.getGas());
        }
    }
}
