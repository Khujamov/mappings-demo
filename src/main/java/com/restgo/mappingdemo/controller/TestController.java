package com.restgo.mappingdemo.controller;

import com.restgo.mappingdemo.entity.Instructor;
import com.restgo.mappingdemo.entity.InstructorDetail;
import com.restgo.mappingdemo.repository.InstructorDetailRepo;
import com.restgo.mappingdemo.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class TestController {

    @Autowired
    private InstructorRepo repo;

    @Autowired
    private InstructorDetailRepo detail;

    @GetMapping("/all")
    public HttpEntity<?> getAll(){
        return ResponseEntity.status(200).body(repo.findAll());
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody Instructor instructor){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.save(instructor));
    }

    @DeleteMapping("/d/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        repo.delete(repo.findById(id).get());
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/get/{hobby}")
    public HttpEntity<?> getInstructor(@PathVariable String hobby){
        InstructorDetail byHobby = detail.findByHobby(hobby);
        return ResponseEntity.status(200).body(byHobby.getInstructor());
    }
}
