package com.example.springbootapi.repository;

import com.example.springbootapi.models.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SampleRepository extends JpaRepository<Sample,Long> {
}
