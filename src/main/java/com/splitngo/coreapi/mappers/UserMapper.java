package com.splitngo.coreapi.mappers;

import com.splitngo.coreapi.dtos.UserDTO;
import com.splitngo.coreapi.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO dto);
}
