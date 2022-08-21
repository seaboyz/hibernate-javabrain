package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.Address;
import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();

        Address address = new Address();
        address.setCity("New York");
        address.setState("New York");
        address.setStreet("123 Main Street");
        address.setZip("10001");
        user.setAddress(address);
        user.setUserId(1);
        user.setUserName("first user");
        user.setJoinedDate(new java.sql.Date(new java.util.Date().getTime()));

        user.setDescription("First User's description");

        UserDetails user2 = new UserDetails();
        user2.setUserName("second user");

        // create a session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // create a session
        Session session = sessionFactory.openSession();
        // start a transaction
        session.beginTransaction();
        // save the object
        session.save(user);
        session.save(user2);
        // commit transaction
        session.getTransaction().commit();
        // close session
        session.close();

    }
}
