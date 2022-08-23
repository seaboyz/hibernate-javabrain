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

        UserDetails user = session.get(UserDetails.class, 1);
        user.setUserName("Updated User Name");

        session.getTransaction().commit();
        session.close();

        // session2
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        UserDetails user2 = session2.get(UserDetails.class, 1);

        session2.getTransaction().commit();
        session2.close();

        System.out.println(user.getUserName());
        System.out.println(user2.getUserName());

    }
}
