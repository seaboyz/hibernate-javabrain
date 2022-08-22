package com.webdev;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("select userName from UserDetails where userId > ?1 and userId < ?2");
        query.setParameter(1, 1);
        query.setParameter(2, 3);

        List<String> users = (List<String>) query.list();

        session.getTransaction().commit();
        session.close();

        for (String user : users) {
            System.out.println(user);
        }

    }
}
