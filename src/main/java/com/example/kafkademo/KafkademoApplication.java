package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkademoApplication implements CommandLineRunner {

    private final DataInitializer dataInitializer;

    @Autowired
    public KafkademoApplication(
            DataInitializer dataInitializer
    ) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkademoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.dataInitializer.init();
    }
}
