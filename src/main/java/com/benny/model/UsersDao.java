package com.benny.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
@Transactional
public class UsersDao {

    @Autowired
//  @Qualifier("sessionFactory")   多組bean指定用
    private SessionFactory sessionFactory;

    public boolean checkLogin(Users user){
        Session session = sessionFactory.openSession();

        String hql = "from Users where username=:user";

        Query<Users> query = session.createQuery(hql, Users.class);
        query.setParameter("user", user.getUsername());

        Users resultBean = query.uniqueResult();

        session.close();

        if(resultBean != null){
            return true;
        }
        return false;
    }
}
