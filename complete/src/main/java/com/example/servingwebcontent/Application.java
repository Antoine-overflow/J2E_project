package com.example.servingwebcontent;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;


public class Application {
    
    public List<Event> events = new ArrayList<Event>(); // List of all the events 
    public List<Participant> participants = new ArrayList<Participant>(); // List of all the participants

    //Application constructor
    public Application(List<Event> events, List<Participant> participants){
        this.events = events;
        this.participants = participants;
    }

    //Getters
    public List<Event> getEvents(){
        return this.events;
    }

    public List<Participant> getParticipants(){
        return this.participants;
    }

    public Event createEvent(String title, String theme, Calendar startingDate, int length, int nbMaxParticipant, String description, Participant organizer, 
     String type){
        Event e = new Event(title, theme, startingDate, length, nbMaxParticipant, description, organizer, type);
        this.events.add(e);
        this.participants.add(organizer);
        return e;
    }

    public Participant createParticipant(String firstName, String lastName, String email, String enterprise, Calendar birthDate){
        Participant p = new Participant(firstName, lastName, email, enterprise, birthDate);
        this.participants.add(p);
        return p;
    }
}
