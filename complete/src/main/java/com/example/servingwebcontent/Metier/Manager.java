package com.example.servingwebcontent.Metier;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;


public class Manager {
    
    public List<Event> events = new ArrayList<Event>(); // List of all the events 
    public List<Participant> participants = new ArrayList<Participant>(); // List of all the participants

    //Manager constructor
    public Manager(List<Event> events, List<Participant> participants){
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

    // Method that return the list of title of events in the app, if the argument is True, the method display titles
    public List<String> listEvents(Boolean display){
        List<Event> events = this.getEvents();
        List<String> titles = new ArrayList<String>();
        for(int k=0; k<events.size();k++){
            String title = events.get(k).getTitle();
            if(display){
                System.out.println("Event n° " + Integer.toString(k+1) + " : " + title);
            }
            titles.add(title);
        }
        return titles;
    }

    public List<List<String>> listParticipants(Event event, Boolean display){
        List<Participant> participant = this.getParticipants();
        List<String> firstNames = new ArrayList<String>();
        List<String> lastNames = new ArrayList<String>();
        for(int k=0; k<participant.size();k++){
            String firstName = participant.get(k).getFirstName();
            String lastName = participant.get(k).getLastName();
            if(display){
                System.out.println("Participant n° " + Integer.toString(k+1) + " : " + firstName + " " + lastName);
            }
            firstNames.add(firstName);
            lastNames.add(lastName);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        result.add(firstNames);
        result.add(lastNames);
        return result;
    }
}
