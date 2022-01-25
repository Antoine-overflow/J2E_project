package com.example.servingwebcontent.Service;

import java.util.List;

import com.example.servingwebcontent.Metier.Event;
import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Session.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EventService {
    
    private final SessionFactory sessionFactory = HibernateUtils.createSessionFactory();

    public EventService() {
    }

    public long create(String title, String theme, String startingDate,
                       int length, int nb_part_max , String description,
                       Participant organisateur, String type) {
        Event event = new Event(title, theme, startingDate, length, nb_part_max, description, organisateur, type);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(event);
        session.getTransaction().commit();
        session.close();
        return event.getId();
    }

    public boolean delete(long id) {
        Event eventToDelete = this.get(id);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(eventToDelete);
        session.getTransaction();
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

    public List<Event> getAll() {
        Session session = sessionFactory.openSession();
        List<Event> result = session.createQuery("from Event").list();
        session.close();
        return result;
    }
}
