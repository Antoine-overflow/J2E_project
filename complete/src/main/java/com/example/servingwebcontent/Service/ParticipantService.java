package com.example.servingwebcontent.Service;

import java.util.List;

import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Session.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT e FROM "+Participant.class.getName()+" e";
        Query<Participant> query = session.createQuery(sql);
        List<Participant> liste = query.getResultList();
        session.close();
        return liste;
    }

    public Participant getParticipantById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "SELECT e FROM "+Participant.class.getName()+" e WHERE e.id_participant="+id;
        Query<Participant> query = session.createQuery(sql);
        Participant p = query.getResultList().get(0);
        session.close();
        return p;
    }

    public Boolean deleteParticipant(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "DELETE Participant WHERE id= :ID";
        Query query = session.createQuery(sql);
        query.setParameter("ID", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public int update(Participant participant){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(participant);
        session.getTransaction().commit();
        session.close();
        return participant.getId();
    }
}
