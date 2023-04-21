package com.intelygenz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private InputRepository repository;

    @Override
    public void run(String... args) {

        int[] integers = {1, 2, 3, 4, 5, 1};
        InputEntity entity = new InputEntity();
        entity.setIntegers(integers);
        repository.save(entity);

    }
}