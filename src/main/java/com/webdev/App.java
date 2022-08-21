package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("seaboyz");

        // create a session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // create a session
        Session session = sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // save the object
        session.save(user);
        // commit transaction
        session.getTransaction().commit();

    }
}
