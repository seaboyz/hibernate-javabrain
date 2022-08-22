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
        user.getVehicles().add(vehicle);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("bike");
        user.getVehicles().add(vehicle2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user);
        // session.save(vehicle);
        // session.save(vehicle2);

        session.getTransaction().commit();
        session.close();

    }
}
