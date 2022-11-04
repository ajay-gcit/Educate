package com.practicespringweb.repository;

import com.practicespringweb.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    List<Patient> findByName(String name);
}
