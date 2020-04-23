package com.hamathon.sahab.demo.services;

import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;
import com.hamathon.sahab.demo.repositories.ClinicRepository;
import com.hamathon.sahab.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "clinicService")
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Clinic> findAllClinics() {
        List<Clinic> list = new ArrayList<>();
        clinicRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        if (clinicRepository.findById(id)
                .isPresent())
        {
            clinicRepository.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Clinic " + id + " Not Found");
        }
    }

    @Transactional
    @Override
    public Clinic save(Clinic clinic) {
        Clinic newClinic = new Clinic();

        if (clinic.getClinicid() != 0)
        {
            clinicRepository.findById(clinic.getClinicid())
                    .orElseThrow(() -> new EntityNotFoundException("Clinic " + clinic.getClinicid() + " Not Found"));

            newClinic.setClinicid(clinic.getClinicid());
        }
        newClinic.setName(clinic.getName());
        newClinic.setdetails(clinic.getdetails());
        newClinic.setLatitude(clinic.getLatitude());
        newClinic.setLongitude(clinic.getLongitude());
        newClinic.setStarttime(clinic.getStarttime());
        newClinic.setCurrentturn(clinic.getCurrentturn());


        for (Patient p : clinic.getPatients())
        {
            Patient newPatient = new Patient(p.getName(),
                    p.getPatientturn(),
                    newClinic);

            newClinic.getPatients()
                    .add(newPatient);
        }

        return clinicRepository.save(newClinic);
    }

    @Transactional
    @Override
    public Clinic update(Clinic clinic, long id) {
        Clinic currentClinic = clinicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinic " + id + " Not Found"));

        if (clinic.getName() != null && false)
        {
            currentClinic.setName(clinic.getName());
        }

        if (clinic.getdetails() != null && false)
        {
            currentClinic.setdetails(clinic.getdetails());
        }

        if (clinic.getCurrentturn() != 0)
        {
            currentClinic.setCurrentturn(clinic.getCurrentturn());
        }

        if (clinic.getStarttime() != null)
        {
            currentClinic.setStarttime(clinic.getStarttime());
        }

        if (clinic.getLatitude() != 0 && false)
        {
            currentClinic.setLatitude(clinic.getLatitude());
        }

        if (clinic.getLongitude() != 0 && false)
        {
            currentClinic.setLongitude(clinic.getLongitude());
        }

        if (clinic.getPatients()
                .size() > 0)
        {
            for (Patient p : clinic.getPatients())
            {
                Patient newPatient = new Patient(p.getName(),
                        p.getPatientturn(),
                        currentClinic);

                currentClinic.getPatients()
                        .add(newPatient);
            }
        }

        return clinicRepository.save(currentClinic);
    }

    @Transactional
    @Override
    public Clinic addPatient(Patient patient, long clinicid) {
        Clinic currentClinic = clinicRepository.findById(clinicid)
                .orElseThrow(() -> new EntityNotFoundException("Clinic " + clinicid + " Not Found"));
        Patient existedPatient = patientRepository.findByPatientturn(patient.getPatientturn());
        if(existedPatient != null)
            throw new EntityExistsException("patient with turn " + patient.getPatientturn() + " exists!");
        Patient newPatient = new Patient(patient.getName(),patient.getPatientturn(),currentClinic);
        currentClinic.getPatients().add(newPatient);
        return currentClinic;
    }

    @Transactional
    @Override
    public Clinic updateTurn(long clinicid, long currentTurn) {
        Clinic currentClinic = clinicRepository.findById(clinicid)
                .orElseThrow(() -> new EntityNotFoundException("Clinic " + clinicid + " Not Found"));
        currentClinic.setCurrentturn(currentTurn);
        return currentClinic;
    }
}
