package com.example.kafkademo;

import com.example.kafkademo.repository.*;
import com.example.kafkademo.repository.entity.GlobalVehicleCounter;
import com.example.kafkademo.repository.entity.Measurement;
import com.example.kafkademo.repository.entity.VehicleType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class DataInitializer {

    private static final Random RANDOM = new Random();

    private static final List<VehicleType> VALUES = List.of(VehicleType.values());

    private static final int SIZE = VALUES.size();

    private final MeasurementRepository measurementRepository;
    private final GlobalVehicleCounterRepository globalVehicleCounterRepository;

    DataInitializer(
            MeasurementRepository measurementRepository,
            GlobalVehicleCounterRepository globalVehicleCounterRepository
    ) {
        this.measurementRepository = measurementRepository;
        this.globalVehicleCounterRepository = globalVehicleCounterRepository;
    }

    public void init() {
        // den auskommentierten Code habe ich nur mal zum Testen der H2 und von JPA geschrieben
//        var now = LocalDateTime.now();
//
//        List<Measurement> measurements = LongStream.range(1, 10)
//                .mapToObj(i -> new Measurement(i, VALUES.get(RANDOM.nextInt(SIZE)), now.plusDays(i)))
//                .collect(Collectors.toList());
//
//        measurementRepository.saveAllAndFlush(measurements);
//
//        measurementRepository.findAll().forEach(System.out::println);


        // hier legen wir schon einmal die Counter mit Wert 0 an, dann müssen wir sie
        // im Service nicht erst erzeugen
        var globalVehicleCounter = List.of(
                new GlobalVehicleCounter(VehicleType.PKW, 0L),
                new GlobalVehicleCounter(VehicleType.LKW_ZWEIACHSER, 0L),
                new GlobalVehicleCounter(VehicleType.LKW_DREIACHSER, 0L)
        );

        globalVehicleCounterRepository.saveAllAndFlush(globalVehicleCounter);
    }
}
