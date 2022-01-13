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
}
