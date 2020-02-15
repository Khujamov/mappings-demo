package com.restgo.mappingdemo.component;

import com.restgo.mappingdemo.entity.Instructor;
import com.restgo.mappingdemo.entity.InstructorDetail;
import com.restgo.mappingdemo.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initialize;

    @Autowired
    private InstructorRepo repo;

    @Override
    public void run(String... args) throws Exception {
        if (initialize.equals("always")){
            repo.save(new Instructor("Rustam",
                    "Toshmatov",
                    new InstructorDetail(
                            "eshmat",
                            "reading")
            ));
            repo.save(new Instructor("Qudrat",
                    "Toshmatov",
                    new InstructorDetail(
                            "good",
                            "swimming")
            ));
        }
    }
}
