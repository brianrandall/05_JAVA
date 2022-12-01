package com.caresoft.clinicapp.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.interfaces.HIPAACompliantAdmin;
import com.caresoft.clinicapp.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
 
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();


    //to do -- constructor that takes an id,
    public AdminUser(Integer id, String role) {
        super(id);
        setEmployeeID(id);
        this.role = role;
    }
    //implement hipaacompliantuser
    @Override
    public boolean assignPin(int pin) {
        if (pin >= 100000 && pin <= 999999) {
            super.setPin(pin);
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (employeeID == confirmedAuthID) {
            return true;
        }
        else {
            this.authIncident();
            return false;
        }
    }
    //implement hipaacompliantadmin
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < this.securityIncidents.size(); i++) {
            output.add(this.securityIncidents.get(i));
        }
        return output;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n, Reported by ID: %s\n Notes: %s\n",
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n, ID: %s\n Notes: %s\n",
            new Date(), this.id, "AUTH ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    //TO do setters and getters
    public Integer getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }
    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
