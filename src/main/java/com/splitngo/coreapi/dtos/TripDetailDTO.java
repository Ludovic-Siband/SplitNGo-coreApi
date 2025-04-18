package com.splitngo.coreapi.dtos;

import java.time.LocalDateTime;

public record TripDetailDTO(
        Integer id,
        String title,
        String description,
        LocalDateTime dateStart,
        LocalDateTime dateEnd,
        LocalDateTime createdAt,
        UserDTO createdBy,
        boolean isActive) {
}
