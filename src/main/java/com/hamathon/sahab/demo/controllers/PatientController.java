package com.hamathon.sahab.demo.controllers;

import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;
import com.hamathon.sahab.demo.services.ClinicService;
import com.hamathon.sahab.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @DeleteMapping(value = "/patient/{patientid}")public ResponseEntity<?> deletePatient(@PathVariable long patientid){
        patientService.delete(patientid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/patient",
            consumes = {"application/json"})
    public ResponseEntity<?> updatePatient(
            @Valid
            @RequestBody
                    Patient patient)
    {
        patientService.update(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
