package com.hamathon.sahab.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patientid;

    private String name;

    //@Column(unique = true, nullable = false)
    private long patientturn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinicid", nullable = false)
    @JsonIgnoreProperties({"patients", "hibernateLazyInitializer"})
    private Clinic clinic;

    public Patient(){

    }

    public Patient(String name, long patientturn, Clinic clinic) {
        this.name = name;
        this.patientturn = patientturn;
        this.clinic = clinic;
    }

    public long getPatientid() {
        return patientid;
    }

    public void setPatientid(long patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPatientturn() {
        return patientturn;
    }

    public void setPatientturn(long patientturn) {
        this.patientturn = patientturn;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientid=" + patientid +
                ", name='" + name + '\'' +
                ", patientturn=" + patientturn +
                ", clinic name=" + clinic.getName() +
                '}';
    }
}
