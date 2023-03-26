package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.api.crud.models.UserModel;


public interface IUserRepository extends JpaRepository<UserModel,Long>{

     
    
}
