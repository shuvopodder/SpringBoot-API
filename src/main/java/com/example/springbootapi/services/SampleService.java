package com.example.springbootapi.services;

import com.example.springbootapi.models.Sample;

import java.util.List;

public interface SampleService {
    List<Sample> getAllData();

    Sample saveData(Sample sample);

    Sample updateData(Sample sample);

    void deleteDataById(Long id);

    Object Home();

    Sample getSampleById(Long id);
}
