package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("Test User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        user.setUserName("Updated User");
        user.setUserName("Updated User Agian");

        session.getTransaction().commit();
        session.close();

        user.setUserName("Updated User Again After Session Closed");
    }
}
