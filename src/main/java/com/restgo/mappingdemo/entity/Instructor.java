package com.restgo.mappingdemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Data
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;

    // by default, no operations are cascaded
    //@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    @JsonProperty("details")
    private InstructorDetail instructorDetail;

    // do not apply cascading deletes
    @OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY)
    private List<Course> courses;

    public Instructor(String firstName, String lastName, InstructorDetail instructorDetail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorDetail = instructorDetail;
        this.courses = new ArrayList<>();
    }


}
