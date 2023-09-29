package com.example.kafkademo.controller;

import com.example.kafkademo.repository.GlobalVehicleCounterRepository;
import com.example.kafkademo.repository.entity.GlobalVehicleCounter;
import com.example.kafkademo.repository.entity.VehicleType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/statistic")
public class StatisticController {

    private final GlobalVehicleCounterRepository globalVehicleCounterRepository;

    public StatisticController(GlobalVehicleCounterRepository globalVehicleCounterRepository) {
        this.globalVehicleCounterRepository = globalVehicleCounterRepository;
    }

    @GetMapping("station/{stationId}")
    public Map<VehicleType, Long> getCountsByStationId(@PathVariable Long stationId) {
        System.out.println("stationId=" + stationId);
        var counter = new HashMap<VehicleType, Long>();
        // todo hier die Map mit den richtigen Werten aus der Datenbank befüllen
        counter.put(VehicleType.PKW, 3L);
        counter.put(VehicleType.LKW_ZWEIACHSER, 10L);
        counter.put(VehicleType.LKW_DREIACHSER, 100L);
        return counter;
    }

    @GetMapping("global-counts")
    public List<GlobalVehicleCounter> getGlobalVehicleCounter() {
        return List.of(); // todo hier alle global counts zurückgeben
    }

}
