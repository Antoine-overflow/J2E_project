package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.List;

public class Event {
    
    public String title; //Title of the event
    public String theme; // Theme of the event
    public long startingDate; // Starting date of the event
    public int length; // Length in days of the event
    public int nbMaxParticipant;   // Number max of participants for the event 
    public String description; // Description of the event
    public Participant organizer; // The organizer of the event
    public String type; //The type of the event
    private int nbParticipant = 0; // The number of participant for the event
    private List<Participant> participants = new ArrayList<Participant>(); // The list of participant for the event

    // Event constructor 
    public Event(String title, String theme,
     long startingDate, int length, int nbMaxParticipant,
      String description, Participant organizer, 
      String type){
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.startingDate = startingDate;
        this.length = length;
        this.organizer = organizer;
        this.type = type;
        this.nbMaxParticipant = nbMaxParticipant;
    }

    // Event getters
    public String getTitle(){
        return this.title;
    }

    public String getTheme(){
        return this.theme;
    }

    public long getStartingDate(){
        return this.startingDate;
    }

    public int getLength(){
        return this.length;
    }

    public int nbMaxParticipant(){
        return this.nbMaxParticipant;
    }

    public String getDescription(){
        return this.description;
    }

    public Participant getOrganizer(){
        return this.organizer;
    }

    public String getType(){
        return this.type;
    }

    public int getNbParticipant(){
        return this.nbParticipant;
    }

    public List<Participant> getParticipants(){
        return this.participants;
    }
    
    // Event setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setTheme(String theme){
        this.theme = theme;
    }

    public void setStartingDate(long startingDate){
        this.startingDate = startingDate;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setNbMaxParticipant(int nbMaxParticipant){
        this.nbMaxParticipant = nbMaxParticipant;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOrganizer(Participant organiser){
        this.organizer = organiser;
    }

    public void setType(String type){
        this.type = type;
    }

    // Add a participant to an event
    public void addParticipant(Participant participant){
        //First we check if we can accept the participant
        if (this.nbMaxParticipant<=this.nbParticipant){
            return;
        }
        
        // We add the participant to the list of participant for the event
        this.participants.add(participant);

        // We increment the number of participant
        this.nbParticipant++;
    }
}
