package com.hamathon.sahab.demo.services;
import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;
import com.hamathon.sahab.demo.repositories.ClinicRepository;
import com.hamathon.sahab.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "patientService")
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void delete(long id) {
        if (patientRepository.findById(id)
                .isPresent())
        {
            patientRepository.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Patient " + id + " Not Found");
        }
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        return null;
    }

    @Transactional
    @Override
    public Patient update(Patient patient) {
        Patient currentPatient = patientRepository.findById(patient.getPatientid())
                .orElseThrow(() -> new EntityNotFoundException("Patient " + patient.getPatientid() + " Not Found"));
        if(patient.getName() != null){
            currentPatient.setName(patient.getName());
        }
        if(patient.getPatientturn() != 0){
            currentPatient.setPatientturn(patient.getPatientturn());
        }
        return null;
    }
}
