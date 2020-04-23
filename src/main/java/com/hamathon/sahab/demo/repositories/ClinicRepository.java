package com.hamathon.sahab.demo.repositories;

import com.hamathon.sahab.demo.models.Clinic;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepository extends CrudRepository<Clinic, Long> {
}
