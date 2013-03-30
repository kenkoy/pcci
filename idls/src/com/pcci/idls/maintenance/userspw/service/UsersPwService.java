package com.pcci.idls.maintenance.userspw.service;

import java.util.List;

import com.pcci.idls.maintenance.userspw.domain.UsersPw;
import com.pcci.idls.maintenance.userspw.domain.UsersPwPK;

public interface UsersPwService {
    public void store(UsersPw usersPw);
    public void delete(UsersPwPK pk);
    public UsersPw findById(UsersPwPK pk);
    public List<UsersPw> findAll();

}
