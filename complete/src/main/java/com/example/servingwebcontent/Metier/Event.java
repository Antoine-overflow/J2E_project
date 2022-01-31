package com.example.servingwebcontent.Metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public long id_event;

    @Column(name ="title")
    public String title; //Title of the event

    @Column(name ="theme")
    public String theme; // Theme of the event

    @Column(name ="Starting_date")
    public String startingDate; // Starting date of the event

    @Column(name ="Day_duration")
    public int length; // Length in days of the event

    @Column(name ="Max_number_of_participants")
    public int nbMaxParticipant;   // Number max of participants for the event 

    @Column(name ="descrption")
    public String description; // Description of the event
  
    @OneToOne 
    @JoinColumn( name="id_organizer")
    public Participant organizer; // The organizer of the event

    @Column(name ="type")
    public String type; //The type of the event
  
    @ManyToMany
    @JoinTable(
        name="EVENT_USER",
        joinColumns = @JoinColumn(name="id_event"),
        inverseJoinColumns = @JoinColumn(name="id_participant") 
    )
    private List<Participant> participants = new ArrayList<Participant>(); // The list of participant for the event

    // Event constructor 
    public Event(){} // For Hibernate

    public Event(String title, String theme, String startingDate, int length, int nbMaxParticipant, String description, String type){
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.startingDate = startingDate;
        this.length = length;
        // this.organizer = organizer;
        this.type = type;
        this.nbMaxParticipant = nbMaxParticipant;
        this.participants = new ArrayList<Participant>();
    }

    public Event(int id_event, String title, String theme, String startingDate, int length, int nbMaxParticipant, String description, String type){
        this.id_event = id_event;
        this.title = title;
        this.description = description;
        this.theme = theme;
        this.startingDate = startingDate;
        this.length = length;
        // this.organizer = organizer;
        this.type = type;
        this.nbMaxParticipant = nbMaxParticipant;
        this.participants = new ArrayList<Participant>();
    }

    // Event getters
    public long getId(){
        return this.id_event;
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
