package com.restgo.mappingdemo.repository;

import com.restgo.mappingdemo.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepo extends JpaRepository<InstructorDetail,Integer> {
    InstructorDetail findByHobby(String hobby);
}
