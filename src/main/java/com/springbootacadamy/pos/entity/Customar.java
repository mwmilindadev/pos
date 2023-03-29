package com.springbootacadamy.pos.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="customar")
@TypeDefs({
        @TypeDef(name="json",typeClass = JsonType.class)
})
public class Customar {
    @Id
    @Column(name="customar_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customarId;

    @Column(name="customar_name",length = 200,nullable = false)
    private String customarName;

    @Column(name="customar_address",length = 200)
    private String customarAdderess;

    @Column(name = "customar_salary")
    private double customarSalary;

    @Type(type = "json")
    @Column(name="conatct_numbers",columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name="nic")
    private String nic;

    @Column(name="active_status",columnDefinition = "TINYINT default 0")
    private boolean activeStatus;

    public Customar() {
    }

    public Customar(int customarId, String customarName, String customarAdderess, double customarSalary, ArrayList contactNumbers, String nic, boolean activeStatus) {
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
        return "Customar{" +
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
