package com.benny.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProfilesDao {

    @Autowired
    private SessionFactory factory;

    public Profiles insert(Profiles pBean){
        Session session = factory.openSession();

        if(pBean != null){
           session.persist(pBean);
           session.flush();
        }
        session.close();
        return pBean;
    }

    public Profiles findById(int id){
        Session session = factory.openSession();

        Profiles resultBean = session.get(Profiles.class, id);

        session.close();
        return resultBean;
    }

    public List<Profiles> findAll() {
        Session session = factory.openSession();

        Query<Profiles> query = session.createQuery("from Profiles", Profiles.class);
        List<Profiles> lists = query.list();

        session.close();
        return lists;
    }

    public Profiles update(Profiles pBean){
        Session session = factory.openSession();

        if(pBean != null){
            session.merge(pBean);
            session.flush();
        }
        session.close();
        return pBean;
    }

    public boolean deleteById(int id) {
        Session session = factory.openSession();
        Profiles resultBean = session.get(Profiles.class, id);

        if(resultBean!=null) {
            session.remove(resultBean);
            session.flush();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

}
