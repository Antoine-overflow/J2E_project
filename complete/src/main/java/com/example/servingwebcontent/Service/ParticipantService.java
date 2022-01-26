package com.example.servingwebcontent.Service;


import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Session.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ParticipantService {
    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public ParticipantService() {
    }

    public int create(String firstName, String lastName, String email, String birthDate,String enterprise) {
        Participant participant = new Participant(firstName, lastName, email, enterprise, birthDate);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getId();
    }

    public int create(Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getId();
    }
}
