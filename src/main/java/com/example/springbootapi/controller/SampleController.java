package com.example.springbootapi.controller;

import com.example.springbootapi.implementation.SampleServiceImpl;
import com.example.springbootapi.models.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    SampleServiceImpl sampleService;

    @GetMapping("/home")
    public ResponseEntity<?> Home(){
        return new ResponseEntity<>(sampleService.Home(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sample>> getSample(){
        return new ResponseEntity<>(sampleService.getAllData(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getSampleById(@PathVariable Long id){
        return new ResponseEntity<>(sampleService.getSampleById(id),HttpStatus.OK);
    }
    @GetMapping("/params") //using params value ex: localhost:8080/sample/params?id=1
    public ResponseEntity<?> getSampleByIdParams(@RequestParam("id") Long id){
        return new ResponseEntity<>(sampleService.getSampleByIdParams(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sample> saveData(@Validated @RequestBody Sample sample){
        return new ResponseEntity<>(sampleService.saveData(sample), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Sample> updateData(@Validated @RequestBody Sample sample){
        return new ResponseEntity<>(sampleService.updateData(sample),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteData(@PathVariable Long id){
        sampleService.deleteDataById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
