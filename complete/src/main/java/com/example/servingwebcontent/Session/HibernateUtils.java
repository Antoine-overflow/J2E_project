package com.example.servingwebcontent.Session;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.servingwebcontent.Metier.Event;
import com.example.servingwebcontent.Metier.Participant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtils {
    //@Autowired
    public static SessionFactory sessionFactory =  createSessionFactory();

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Participant.class);
            configuration.addAnnotatedClass(Event.class);
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }

    // public static SessionFactory createSessionFactory(){
    //     final StandardServiceRegistry registry = 
    //         new StandardServiceRegistryBuilder()
    //             .configure()
    //             .build();
    //     try {
    //             return new MetadataSources(registry)
    //                 .buildMetadata()
    //                 .buildSessionFactory();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    //         StandardServiceRegistryBuilder.destroy(registry);
    //     }
    //     return null;
    // }
}
