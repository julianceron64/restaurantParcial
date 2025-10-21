package eurekaexercise.user.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import eurekaexercise.user.DTO.UserDTO;
import eurekaexercise.user.entities.User;
import eurekaexercise.user.mapper.UserMapper;
import eurekaexercise.user.repositories.UserRepo;
     


@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(userMapper::mapUserToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO addUserInDB(UserDTO userDTO) {
        User savedUser = userRepo.save(userMapper.mapUserDTOToUser(userDTO));
        return userMapper.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.mapUserToUserDTO(user.get()), HttpStatus.OK);
    }
}

