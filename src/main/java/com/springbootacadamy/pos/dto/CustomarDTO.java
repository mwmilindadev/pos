package com.springbootacadamy.pos.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

public class CustomarDTO {

    private int customarId;
    private String customarName;

    private String customarAdderess;

    private double customarSalary;

    private ArrayList contactNumbers;

    private String nic;


    private boolean activeStatus;

    public CustomarDTO() {
    }

    public CustomarDTO(int customarId, String customarName, String customarAdderess, double customarSalary, ArrayList contactNumbers, String nic, boolean activeStatus) {
        this.customarId = customarId;
        this.customarName = customarName;
        this.customarAdderess = customarAdderess;
        this.customarSalary = customarSalary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeStatus = activeStatus;
    }

    public int getCustomarId() {
        return customarId;
    }

    public void setCustomarId(int customarId) {
        this.customarId = customarId;
    }

    public String getCustomarName() {
        return customarName;
    }

    public void setCustomarName(String customarName) {
        this.customarName = customarName;
    }

    public String getCustomarAdderess() {
        return customarAdderess;
    }

    public void setCustomarAdderess(String customarAdderess) {
        this.customarAdderess = customarAdderess;
    }

    public double getCustomarSalary() {
        return customarSalary;
    }

    public void setCustomarSalary(double customarSalary) {
        this.customarSalary = customarSalary;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "CustomarDTO{" +
                "customarId=" + customarId +
                ", customarName='" + customarName + '\'' +
                ", customarAdderess='" + customarAdderess + '\'' +
                ", customarSalary=" + customarSalary +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
