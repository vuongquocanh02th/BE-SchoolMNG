package com.school_management_api.service.user;

import com.school_management_api.model.User;
import com.school_management_api.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUserService extends IGenericService<User>{
    UserDetails loadUserByUsername(String username);
    Optional<User> findByUsername(String username);
}