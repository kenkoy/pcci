package com.pcci.idls.maintenance.users.service;

import java.util.List;

import com.pcci.idls.maintenance.users.domain.Users;

public interface UsersService {
    public void store(Users users);
    public void delete(String userId);
    public Users findById(String userId);
    public List<Users> findAll();

}
