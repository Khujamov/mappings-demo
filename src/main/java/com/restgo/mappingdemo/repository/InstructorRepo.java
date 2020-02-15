package com.restgo.mappingdemo.repository;

import com.restgo.mappingdemo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
    Instructor findById(int id);
}
