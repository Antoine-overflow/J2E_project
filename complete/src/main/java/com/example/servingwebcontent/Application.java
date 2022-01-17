package com.example.servingwebcontent;

import java.util.List;

public class Application {
    
    public List<Event> events; // List of all the events 
    public List<Participant> participants; // List of all the participants

    public void addEvent(Event event){
        this.events.add(event);
    }

    public List<Event> getEvents(){
        return this.events;
    }

    public Event createEvent(String title, String theme, long startingDate, int length, int nbMaxParticipant, String description, Participant organizer, 
     String type){
        return new Event(title, theme, startingDate, length, nbMaxParticipant, description, organizer, type);
    }

    public Participant createParticipant(String firstName, String lastName, String email, String enterprise, long birthDate){
         return new Participant(firstName, lastName, email, enterprise, birthDate);
    }
}
