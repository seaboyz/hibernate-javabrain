package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
        System.out.println(user.getUserName());

        session.getTransaction().commit();
        session.close();

        user.setUserName("Updated User Name After Session Close");

        session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(user);

        user.setUserName("Updated User Name After Session Open");

        session.getTransaction().commit();
        session.close();

        System.out.println(user.getUserName());

    }
}
