package com.hamathon.sahab.demo.services;
import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;

import java.util.List;

public interface ClinicService {
    List<Clinic> findAllClinics();
    void delete(long id);
    Clinic save(Clinic clinic);
    Clinic update(Clinic clinic, long id);
    Clinic addPatient(Patient patient,long clinicid);

    Clinic updateTurn(long clinicid, long currentTurn);
}
