package com.splitngo.coreapi.services;

import com.splitngo.coreapi.dtos.TripDTO;
import com.splitngo.coreapi.dtos.TripDetailDTO;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Data
public class TripService {

    public List<TripDTO> getAllTrips() {
        TripDTO trip1 = new TripDTO();
        trip1.setId(150);
        trip1.setTitle("Trip to Paris");
        trip1.setDescription("A wonderful trip to Paris with friends.");
        trip1.setDateStart(LocalDateTime.of(2023, 10, 1, 10, 0));
        trip1.setDateEnd(LocalDateTime.of(2023, 10, 10, 18, 0));
        trip1.setCreatedAt(LocalDateTime.now());
        trip1.setActive(true);
        trip1.setCreatedBy("Polo");

        TripDTO trip2 = new TripDTO();
        trip2.setId(151);
        trip2.setTitle("Trip to London");
        trip2.setDescription("A delightful journey to explore London's history.");
        trip2.setDateStart(LocalDateTime.of(2023, 11, 5, 8, 0));
        trip2.setDateEnd(LocalDateTime.of(2023, 11, 12, 20, 0));
        trip2.setCreatedAt(LocalDateTime.now());
        trip2.setActive(true);
        trip2.setCreatedBy("Chris");

        TripDTO trip3 = new TripDTO();
        trip3.setId(152);
        trip3.setTitle("Trip to Tokyo");
        trip3.setDescription("An exciting adventure in the heart of Tokyo.");
        trip3.setDateStart(LocalDateTime.of(2024, 1, 15, 9, 0));
        trip3.setDateEnd(LocalDateTime.of(2024, 1, 25, 21, 0));
        trip3.setCreatedAt(LocalDateTime.now());
        trip3.setActive(true);
        trip3.setCreatedBy("Alex");

        return List.of(trip1, trip2, trip3);
    }


    public TripDetailDTO getTripById(@PathVariable int id) {
        TripDetailDTO trip1 = new TripDetailDTO();
        trip1.setId(1);
        trip1.setTitle("Trip to Paris");
        trip1.setDescription("A wonderful trip to Paris with friends.");
        trip1.setDateStart(LocalDateTime.of(2023, 10, 1, 10, 0));
        trip1.setDateEnd(LocalDateTime.of(2023, 10, 10, 18, 0));
        trip1.setCreatedAt(LocalDateTime.now());
        trip1.setActive(true);
        trip1.setCreatedBy("Polo");

        return trip1;
    }

}
