package com.hamathon.sahab.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clinics")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clinicid;

    private String name;

    private String details;

    private long currentturn;

    private String starttime;

    private double latitude;

    private double longitude;

    @OneToMany(mappedBy = "clinic",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("clinic")
    private List<Patient> patients = new ArrayList<>();

    public Clinic(){

    }

    public Clinic(String name, String details, long currentturn, String starttime, double latitude, double longitude, List<Patient> patients) {
        this.name = name;
        this.details = details;
        this.currentturn = currentturn;
        this.starttime = starttime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.patients = patients;
    }

    public long getClinicid() {
        return clinicid;
    }

    public void setClinicid(long clinicid) {
        this.clinicid = clinicid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdetails() {
        return details;
    }

    public void setdetails(String details) {
        this.details = details;
    }

    public long getCurrentturn() {
        return currentturn;
    }

    public void setCurrentturn(long currentturn) {
        this.currentturn = currentturn;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinicid=" + clinicid +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", currentturn=" + currentturn +
                ", starttime='" + starttime + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", patients=" + patients +
                '}';
    }
}
