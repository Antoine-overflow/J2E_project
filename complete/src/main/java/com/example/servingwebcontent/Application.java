package com.example.servingwebcontent;

import java.util.List;
import java.util.Calendar;


public class Application {
    
    public List<Event> events; // List of all the events 
    public List<Participant> participants; // List of all the participants

    public void addEvent(Event event){
        this.events.add(event);
    }

    public List<Event> getEvents(){
        return this.events;
    }

    public Event createEvent(String title, String theme, Calendar startingDate, int length, int nbMaxParticipant, String description, Participant organizer, 
     String type){
        return new Event(title, theme, startingDate, length, nbMaxParticipant, description, organizer, type);
    }

    public Participant createParticipant(String firstName, String lastName, String email, String enterprise, Calendar birthDate){
         return new Participant(firstName, lastName, email, enterprise, birthDate);
    }
}
