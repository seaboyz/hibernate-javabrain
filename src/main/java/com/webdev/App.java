package com.webdev;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(UserDetails.class);
        criteria.add(Restrictions.eq("userName", "User 10"));

        List<UserDetails> users = (List<UserDetails>) criteria.list();

        session.getTransaction().commit();
        session.close();

        for (UserDetails user : users) {
            System.out.println(user.getUserName());
        }

    }
}
