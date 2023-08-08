package com.benny.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfilesService {

    @Autowired
    private ProfilesDao pDao;

    public Profiles insert(Profiles pBean){
        return pDao.insert(pBean);
    }

    public Profiles findById(int id){
        return pDao.findById(id);
    }

    public List<Profiles> findAll(){
        return pDao.findAll();
    }

    public Profiles update(Profiles pBean){
        return pDao.update(pBean);
    }

    public boolean deleteById(int id){
        return pDao.deleteById(id);
    }

}
