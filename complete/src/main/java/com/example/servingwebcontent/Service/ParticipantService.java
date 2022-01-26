package com.example.servingwebcontent.Service;


import java.util.ArrayList;
import java.util.List;

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

    public long create (Participant participant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getId();
    }

    public List<Participant> getAllParticipant () {
        List<Participant> liste = new ArrayList<>();
        Participant p1 = new Participant("Jules", "Pierrat", "jules.pierrat@ensg.eu", "Jules Pierrat EIRL", "1998-02-21");
        Participant p2 = new Participant("Julie", "Kaltenbacher", "julie.kaltenbacher@gmail.com", "Kine", "2000-03-12");
        Participant p3 = new Participant("Marie-Sophie", "Gabagnou", "marie-sophie.gabagnou@hotmail.fr", "Knorr", "1998-02-18");
        Participant p4 = new Participant("Ines", "Mebarki", "ines.mebarki@outlook.fr", "Crédit Lyonnais", "1998-06-30");

        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
        liste.add(p4);

        return liste;
    }

    public Participant getParticipantById(long id){
        Participant p = new Participant("Jules", "Pierrat", "jules.pierrat@ensg.eu", "Jules Pierrat EIRL", "1998-02-21");
        return p;
    }
}
