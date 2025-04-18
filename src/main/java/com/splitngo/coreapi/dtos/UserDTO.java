package com.splitngo.coreapi.dtos;

public record UserDTO(
        Integer id,
        String lastName,
        String firstName,
        String mail) {
}
