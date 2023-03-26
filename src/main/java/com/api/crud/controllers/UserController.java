package com.api.crud.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ArrayList<Object> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody UserModel user) {
        this.userService.savUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){

            return this.userService.getById(id);
    }
    
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable("id") Long id){
        return this.userService.updateById(request, id);

    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id){
        boolean ok=this.userService.deleteUser(id);

        if (ok) {
            System.out.println("TODO CORRECTO");
        }
        else{
            System.out.println("SALIO MAL EN userController.deleteuser()");
        }
    }
    
    
    
}
