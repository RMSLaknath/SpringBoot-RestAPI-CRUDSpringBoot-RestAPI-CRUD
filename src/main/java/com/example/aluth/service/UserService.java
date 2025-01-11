package com.example.aluth.service;

import com.example.aluth.dto.UserDTO;
import com.example.aluth.model.User;
import org.modelmapper.TypeToken;
import com.example.aluth.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO saveUser(UserDTO userDTO){
    userRepo.save(modelMapper.map(userDTO,User.class));
    return userDTO;
    }
}
