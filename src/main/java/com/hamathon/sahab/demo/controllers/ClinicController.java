package com.hamathon.sahab.demo.controllers;

import com.hamathon.sahab.demo.models.Clinic;
import com.hamathon.sahab.demo.models.Patient;
import com.hamathon.sahab.demo.services.ClinicService;
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
@RequestMapping("/clinics")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    // http://127.0.0.1:port/clinics/clinics
    @GetMapping(value = "/clinics", produces = {"application/json"})
    public ResponseEntity<?> listAllClinics()
    {
        List<Clinic> myClinics = clinicService.findAllClinics();
        return new ResponseEntity<>(myClinics, HttpStatus.OK);
    }

    // http://127.0.0.1:port/clinics/clinic
    @PostMapping(value = "/clinic",
            consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(
            @Valid
            @RequestBody
                    Clinic newClinic)
    {
        // ids are not recognized by the Post method
        newClinic.setClinicid(0);
        newClinic = clinicService.save(newClinic);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newClinicURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{clinicid}")
                .buildAndExpand(newClinic.getClinicid())
                .toUri();
        responseHeaders.setLocation(newClinicURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/clinic/{clinicid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateFullClinic(
            @Valid
            @RequestBody
                    Clinic updateClinic,
            @PathVariable
                    long clinicid)
    {
        updateClinic.setClinicid(clinicid);
        clinicService.save(updateClinic);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/clinic/{clinicid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateClinic(
            @RequestBody
                    Clinic updateClinic,
            @PathVariable
                    long clinicid)
    {
        clinicService.update(updateClinic,
                clinicid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/clinic/{clinicid}")public ResponseEntity<?> deleteClinic(@PathVariable long clinicid){
        clinicService.delete(clinicid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/patient/{clinicid}",
            consumes = {"application/json"})
    public ResponseEntity<?> addPatientToClinic(
            @Valid
            @RequestBody
                    Patient patient,
            @PathVariable
                    long clinicid)
    {
        clinicService.addPatient(patient,clinicid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/turn/{clinicid}/{currentTurn}")
    public ResponseEntity<?> updateTurn(
            @Valid
            @PathVariable
                    long clinicid,
            @PathVariable
                    long currentTurn)
    {
        clinicService.updateTurn(clinicid,currentTurn);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
