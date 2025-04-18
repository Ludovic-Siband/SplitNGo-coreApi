package com.splitngo.coreapi.mappers;

import com.splitngo.coreapi.dtos.TripDTO;
import com.splitngo.coreapi.dtos.TripDetailDTO;
import com.splitngo.coreapi.entity.Trip;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TripMapper {

    TripDTO toDTO(Trip trip);

    Trip toEntity(TripDTO tripDTO);

    List<TripDTO> toDTO(List<Trip> trips);

    List<Trip> toEntity(List<TripDTO> trips);

    TripDetailDTO toDetailDTO(Trip trip);

    Trip toEntity(TripDetailDTO tripDetailDTO);
}
