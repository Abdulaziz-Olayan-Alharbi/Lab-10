package com.example.lab_10.Service;


import com.example.lab_10.Model.User;
import com.example.lab_10.Repository.UserRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    public ArrayList<User> getAllUsers() {
        return new ArrayList<User>(userRepository.findAll());
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id,User user) {
        User u = userRepository.getById(id);
        if (userRepository.existsById(id)) {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            u.setAge(user.getAge());
            userRepository.save(u);
            return true;
        }
        return false;
    }

    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }







}
