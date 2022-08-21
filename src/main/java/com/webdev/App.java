package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.Address;
import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();

        Address address1 = new Address();
        address1.setStreet("123 Main Street");
        address1.setCity("Anytown");
        address1.setState("CA");
        address1.setZip("12345");

        Address address2 = new Address();
        address2.setStreet("456 Office Street");
        address2.setCity("Anytown");
        address2.setState("CA");
        address2.setZip("12345");

        user.getListOfAddresses().add(address1);
        user.getListOfAddresses().add(address2);

        user.setUserId(1);
        user.setUserName("first user");
        user.setJoinedDate(new java.sql.Date(new java.util.Date().getTime()));
        user.setDescription("First User's description");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
