package com.splitngo.coreapi.services;

import com.splitngo.coreapi.dtos.TripDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class TripService {

    public List<TripDTO> getAllTrips() {
        TripDTO trip1 = new TripDTO();
        trip1.setId(1L);
        trip1.setTitle("Trip to Paris");
        trip1.setDescription("A wonderful trip to Paris with friends.");
        trip1.setDateStart(LocalDateTime.of(2023, 10, 1, 10, 0));
        trip1.setDateEnd(LocalDateTime.of(2023, 10, 10, 18, 0));
        trip1.setCreatedAt(LocalDateTime.now());
        trip1.setActive(true);
        trip1.setCreatedBy("Polo");

        return List.of(trip1);
    }
}
