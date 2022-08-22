package com.webdev;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from UserDetails");
        query.setFirstResult(5);
        query.setMaxResults(3);

        List<UserDetails> users = (List<UserDetails>) query.list();

        session.getTransaction().commit();
        session.close();

        for (UserDetails user : users) {
            System.out.println(user.getUserId() + ": " + user.getUserName());
        }

    }
}
