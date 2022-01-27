package com.example.servingwebcontent.Session;

import com.example.servingwebcontent.Metier.Participant;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    
    public final SessionFactory sessionFactory =  createSessionFactory();
    public static SessionFactory createSessionFactory(){
        final StandardServiceRegistry registry = 
            new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
                return new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }
}
