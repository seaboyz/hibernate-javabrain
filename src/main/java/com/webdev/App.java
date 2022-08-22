package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.UserDetails;
import com.webdev.dto.Vehicle;

public class App {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();

        user.setUserName("first user");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("car");

        user.setVehicle(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);
        session.save(vehicle);

        session.getTransaction().commit();
        session.close();

    }
}
