package com.splitngo.coreapi.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private LocalDateTime createdAt;
    private String createdBy;
    private boolean isActive;
}
