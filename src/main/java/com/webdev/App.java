package com.webdev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webdev.dto.FourWheeler;
import com.webdev.dto.TwoWheeler;
import com.webdev.dto.Vehicle;

public class App {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Porsche");
        car.setSteeringWheel("Porsche Steering Wheel");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(vehicle);
        session.save(bike);
        session.save(car);

        session.getTransaction().commit();
        session.close();

    }
}
