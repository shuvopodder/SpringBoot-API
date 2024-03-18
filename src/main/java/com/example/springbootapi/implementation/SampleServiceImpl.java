package com.example.springbootapi.implementation;

import com.example.springbootapi.exception.DataNotFoundException;
import com.example.springbootapi.models.Sample;
import com.example.springbootapi.repository.SampleRepository;
import com.example.springbootapi.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleRepository sampleRepository;
    @Override
    public List<Sample> getAllData() {
        return sampleRepository.findAll();
    }

    @Override
    public Sample getSampleById(Long id) {
        return sampleRepository.findById(id).orElseThrow(()-> new DataNotFoundException(id));
    }

    @Override
    public Object getSampleByIdParams(Long id) {
        return sampleRepository.findById(id).orElseThrow(()-> new DataNotFoundException(id));
    }

    @Override
    public Sample saveData(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public Sample updateData(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public void deleteDataById(Long id) {
        sampleRepository.deleteById(id);
    }

    @Override
    public Object Home() {
        return "Hello, SPRING API SERVICES!";
    }
}
