package com.example.servingwebcontent.Metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

//@Entity
//@Table(name = "Events")
public class Event {

    @Id
    private long id;

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
  
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "idz",column = @Column(name = "Id")),
    @AttributeOverride(name = "firstName",column = @Column(name = "first_name")),
    @AttributeOverride(name = "lastName",column = @Column(name = "last_name")),
    @AttributeOverride(name = "email",column = @Column(name = "email")),
    @AttributeOverride(name = "enterprise",column = @Column(name = "enterprise")),
    @AttributeOverride(name = "comment",column = @Column(name = "comment")),
    @AttributeOverride(name = "birthDate",column = @Column(name = "birthdate")) })
    public Participant organizer; // The organizer of the event

    @Column(name ="type")
    public String type; //The type of the event

    @Column(name ="Number_of_participant")
    private int nbParticipant = 1; // The number of participant for the event
  
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<Participant>(); // The list of participant for the event

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
        this.id = Objects.hash(title,theme,description,type,startingDate);
        this.participants = new ArrayList<Participant>();
        participants.add(organizer);
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
