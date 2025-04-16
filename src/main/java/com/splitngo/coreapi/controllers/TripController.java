package com.splitngo.coreapi.controllers;

import com.splitngo.coreapi.dtos.TripDTO;
import com.splitngo.coreapi.dtos.TripDetailDTO;
import com.splitngo.coreapi.services.TripService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@Data
public class TripController {

    private final TripService tripService;

    @GetMapping
    public List<TripDTO> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public TripDetailDTO getTripById(@PathVariable int id) {
        return tripService.getTripByID(id);
    }

}
