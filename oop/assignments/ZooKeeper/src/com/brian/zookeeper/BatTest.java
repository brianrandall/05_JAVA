package com.brian.zookeeper;
import com.brian.zookeeper.models.Bat;

public class BatTest {
    public static void main(String[] args) {
        
        Bat batMan = new Bat();

        batMan.attackTown();
        batMan.attackTown();
        batMan.attackTown();

        batMan.eatHumans();
        batMan.eatHumans();

        batMan.fly();

    } 
}
