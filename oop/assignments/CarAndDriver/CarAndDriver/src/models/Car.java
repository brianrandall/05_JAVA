package models;
public class Car {

    private int gas;
    
    public Car() {
        this.setGas(10);
    }

    public int getGas() {
        return this.gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }
}