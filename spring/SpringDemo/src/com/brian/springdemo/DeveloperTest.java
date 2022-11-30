package com.brian.springdemo;

import java.util.ArrayList;

import com.brian.springdemo.models.Developer;

public class DeveloperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.out.println("---------Developer Test---------");

        Developer dev1 = new Developer("Radyn Greenwell",true,100000,5.2);

        ArrayList<String> lang = new ArrayList<String>();
        lang.add("Java");
        lang.add("Python");

        dev1.setLanguages(lang);

        System.out.println(dev1.displayStats());
        System.out.println(Developer.getDevCount());
        System.out.println(Developer.getTotalSalaries());
	}
	
}
