package com.devclass.camadasormdto.services;

import com.devclass.camadasormdto.dto.UserDTO;
import com.devclass.camadasormdto.entities.User;
import com.devclass.camadasormdto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> findAll(){
        List<User> usersEntity = userRepository.findAll();
        List<UserDTO> usersDTO = null;

        for (User userEntity : usersEntity) {
            UserDTO userDTO = new UserDTO(userEntity);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User userEntity = userRepository.findById(id).get();
        UserDTO userDTO = new UserDTO(userEntity);
        return userDTO;

    }
}
