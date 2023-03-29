package com.springbootacadamy.pos.dto.request;

public class CustomarUpdateDTO {

    private int customarId;
    private String customarName;
    private String customarAdderess;
    private double customarSalary;

    public CustomarUpdateDTO() {
    }

    public CustomarUpdateDTO(int customarId, String customarName, String customarAdderess, double customarSalary) {
        this.customarId = customarId;
        this.customarName = customarName;
        this.customarAdderess = customarAdderess;
        this.customarSalary = customarSalary;
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

    @Override
    public String toString() {
        return "CustomarUpdateDTO{" +
                "customarId=" + customarId +
                ", customarName='" + customarName + '\'' +
                ", customarAdderess='" + customarAdderess + '\'' +
                ", customarSalary=" + customarSalary +
                '}';
    }
}
