package com.practicespringweb.services;

import com.practicespringweb.entities.Patient;
import com.practicespringweb.repository.PatientRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PatientImp implements PatientService{

    private final PatientRepo repo;

    public PatientImp(PatientRepo repo) {
        this.repo = repo;
    }
    @Override
    public Patient savePatient(Patient patient){
        return repo.save(patient);
    }
    @Override
    public Optional<Patient> getPatient(Long id){
        return repo.findById(id);
    }
    @Override
    public List<Patient> getAllPatients(){
        return repo.findAll();
    }
    @Override
    public void deletePatient(@PathVariable Long id){
        repo.deleteById(id);
    }
    @Override
    public List<Patient> filterByName(String name) {
        return repo.findByName(name);
    }
}
