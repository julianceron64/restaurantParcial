package eurekaexercise.user.mapper;

import org.mapstruct.Mapper;

import eurekaexercise.user.DTO.UserDTO;
import eurekaexercise.user.entities.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO(User user);
}

