package com.restgo.mappingdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
@Data
@NoArgsConstructor
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "channel_name")
    @JsonProperty("channel_name")
    private String channelName;

    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    @JsonIgnore
    private Instructor instructor;


    public InstructorDetail(String channelName, String hobby) {
        this.channelName = channelName;
        this.hobby = hobby;
    }
}
