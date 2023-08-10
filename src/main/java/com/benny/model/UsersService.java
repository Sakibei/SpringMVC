package com.benny.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {

    @Autowired
    public UsersDao uDao;

    public boolean checkLogin(Users user){
        return uDao.checkLogin(user);
    }
}
