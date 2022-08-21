package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("first user");
        user.setJoinedDate(new java.sql.Date(new java.util.Date().getTime()));
        user.setAddress("First User's address");
        user.setDescription("First User's description");

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
        // close session
        session.close();

        user = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetails) session.get(UserDetails.class, 1);

        System.out.println("User Name: " + user.getUserName());
    }
}
