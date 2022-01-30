package com.example.servingwebcontent.Service;

import java.util.List;

import com.example.servingwebcontent.Metier.Event;
import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Session.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EventService {
    
    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public EventService() {
    }

    public long create(String title, String theme, String startingDate,
                       int length, int nb_part_max , String description,
                       Participant organisateur, String type) {
        Event event = new Event(title, theme, startingDate, length, nb_part_max, description, type);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(event);
        session.getTransaction().commit();
        session.close();
        return event.getId();
    }

    public long create(Event event){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(event);
        session.getTransaction().commit();
        session.close();
        return event.getId();
    }

    public boolean delete(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "DELETE Event WHERE id= :ID";
        Query query = session.createQuery(sql);
        query.setParameter("ID", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Event get(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Event result = session.get(Event.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public List<Event> getAllEvent() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String sql = "SELECT e FROM "+Event.class.getName()+" e";
        Query<Event> query = session.createQuery(sql);
        List<Event> liste = query.getResultList();
        session.close();
        return liste;
    }
}
