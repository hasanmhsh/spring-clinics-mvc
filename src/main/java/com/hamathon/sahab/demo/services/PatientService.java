package com.hamathon.sahab.demo.services;

import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;

public interface PatientService {
    void delete(long id);
    Patient save(Patient patient);
    Patient update(Patient patient);
}
