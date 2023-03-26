package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<Object> getUsers() {
        ArrayList<Object> lista = new ArrayList<>();
        for (Object user : userRepository.findAll()) {
            lista.add(user);
        }
        return lista;
    }

    public void savUser(UserModel user) {
        userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        UserModel user =new UserModel();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setId(id);
        userRepository.save(user);
        

        return user;

    }

    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:  "+e.getMessage());
            return false;
        }
    }

}
