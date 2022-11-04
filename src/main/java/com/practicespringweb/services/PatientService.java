package com.practicespringweb.services;

import com.practicespringweb.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);

    Optional<Patient> getPatient(Long id);

    List<Patient> getAllPatients();

    void deletePatient(Long id);

    List<Patient> filterByName(String name);
}
