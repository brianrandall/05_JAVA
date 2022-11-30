package com.brian.zookeeper;
import com.brian.zookeeper.models.Gorilla;

public class GorillaTest {
    public static void main(String[] args) throws Exception {
        
        Gorilla KingKong = new Gorilla();

        KingKong.throwSomething();
        KingKong.throwSomething();
        KingKong.throwSomething();

        KingKong.eatBananas();
        KingKong.eatBananas();

        KingKong.climb();
    }
}
