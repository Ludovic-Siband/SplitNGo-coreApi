package com.splitngo.coreapi.services;

import com.splitngo.coreapi.dtos.TripDTO;
import com.splitngo.coreapi.dtos.TripDetailDTO;
import com.splitngo.coreapi.entity.Trip;
import com.splitngo.coreapi.mappers.TripMapper;
import com.splitngo.coreapi.repositories.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    /**
     * Retrieves all trips from the database and maps them to DTOs.
     *
     * @return a list of {@link TripDTO} objects representing all trips.
     */
    public List<TripDTO> getAllTrips() {
        return tripMapper.toDTO(tripRepository.findAll());
    }

    /**
     * Retrieves the details of a trip by its unique identifier.
     *
     * @param id the unique identifier of the trip to retrieve.
     * @return a {@link TripDetailDTO} representing the detailed information of the trip.
     * @throws EntityNotFoundException if no trip with the specified ID is found.
     */
    public TripDetailDTO getTripById(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip with ID " + id + " not found"));
        return tripMapper.toDetailDTO(trip);
    }
}
