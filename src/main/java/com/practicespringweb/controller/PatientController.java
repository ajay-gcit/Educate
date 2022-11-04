package com.practicespringweb.controller;

import com.practicespringweb.entities.Patient;
import com.practicespringweb.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/patient")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient){
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Optional<Patient>> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatient(id), HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        Optional<Patient> patient = patientService.getPatient(id);
        if (patient.isPresent()) {
            patientService.deletePatient(id);
            return new ResponseEntity<>("Patient Deleted Successfully with ID: " + id, HttpStatus.NO_CONTENT);
        }
        throw new RuntimeException("patient Not Found!");
    }

    @GetMapping("/patient/filterByName")
    public ResponseEntity<List<Patient>> filterByName(@RequestParam String name){
        return new ResponseEntity<>(patientService.filterByName(name), HttpStatus.OK);
    }

}
