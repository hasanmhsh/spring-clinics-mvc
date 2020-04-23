package com.hamathon.sahab.demo.repositories;

import com.hamathon.sahab.demo.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findByPatientturn(long patientturn);
}
