/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.finalApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.finalApi.model.Role;

/**
 *
 * @author didin
 */
public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
    
}
