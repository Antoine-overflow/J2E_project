package com.example.servingwebcontent.Metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @Column(name = "id")
    private long id = 0;

    @Column(name ="title")
    public String title; //Title of the event

    @Column(name ="theme")
    public String theme; // Theme of the event

    @Column(name ="Starting date")
    public String startingDate; // Starting date of the event

    @Column(name ="Day duration")
    public int length; // Length in days of the event

    @Column(name ="Max number of participants")
    public int nbMaxParticipant;   // Number max of participants for the event 

    @Column(name ="descrption")
    public String description; // Description of the event

    @OneToMany
    @JoinColumn(name="id")
    public Participant organizer; // The organizer of the event

    @Column(name ="type")
    public String type; //The type of the event

    @Column(name ="Number of participant")
    private int nbParticipant = 1; // The number of participant for the event

    @OneToMany
    @JoinColumn(name = "id")
    private List<Participant> participants = new ArrayList<>(); // The list of participant for the event

    // Event constructor 
    public Event(){} // For Hibernate

    public Event(String title, String theme, String startingDate, int length, int nbMaxParticipant, String description, Participant organizer, String type){
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.startingDate = startingDate;
        this.length = length;
        // this.organizer = organizer;
        this.type = type;
        this.nbMaxParticipant = nbMaxParticipant;
        // this.participants = new ArrayList<Participant>();
        // participants.add(organizer);
    }

    // Event getters
    public long getId(){
        return this.id;
    }
    
    public String getTitle(){
        return this.title;
    }

    public String getTheme(){
        return this.theme;
    }

    public String getStartingDate(){
        return this.startingDate;
    }

    public int getLength(){
        return this.length;
    }

    public int getNbMaxParticipant(){
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

    public void setStartingDate(String startingDate){
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

    //Detail display of the event
    public void displayEvent(){
        System.out.println("Event title : " + this.title);
        System.out.println("Event theme : " + this.theme);
        System.out.println("Event starting date : " + this.startingDate);
        System.out.println("Event day duration : " + Integer.toString(this.length));
        System.out.println("Event max participant : " + Integer.toString(this.nbMaxParticipant));
        System.out.println("Event description : " + this.description);        
        System.out.println("Event organizer name : " + this.organizer.getFirstName() + " " + this.organizer.getLastName());
        System.out.println("Event type : " + this.type);
    }
}
