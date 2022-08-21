package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.Address;
import com.webdev.dto.UserDetails;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();

        Address homAddress = new Address();
        homAddress.setStreet("123 Main Street");
        homAddress.setCity("Anytown");
        homAddress.setState("CA");
        homAddress.setZip("12345");
        user.setHomeAddress(homAddress);

        Address officeAddress = new Address();
        officeAddress.setStreet("456 Office Street");
        officeAddress.setCity("Anytown");
        officeAddress.setState("CA");
        officeAddress.setZip("12345");
        user.setOfficeAddress(officeAddress);

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
