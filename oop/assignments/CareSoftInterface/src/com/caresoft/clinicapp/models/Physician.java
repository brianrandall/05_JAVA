package com.caresoft.clinicapp.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {

    private ArrayList<String> patientNotes;
    //constructor that takes an id
    public Physician (Integer id) {
        super(id);
    }

    //implement hipaacompliantuser
    @Override
    public boolean assignPin(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            super.setPin(pin);
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (super.id == confirmedAuthID) {
            return true;
        }
        else {
            return false;
        }
    }

    public void newPatientNotes (String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format(
            "Reported by ID: %s \n", this.id);
        report += String.format(
            "Patient Name: %s \n", patientName);
        report += String.format(
            "Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }
    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}