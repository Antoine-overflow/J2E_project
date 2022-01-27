package com.example.servingwebcontent.Metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Embeddable
@Table(name = "Participants")
public class Participant {

    @Column(name = "identifier")
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Autowired
    public int participantID;
  
    @Column(name ="firstName")
    public String firstName;

    @Column(name ="lastName")
    public String lastName;

    @Column(name ="email")
    public String email;

    @Column(name ="birthDate")
    public String birthDate;

    @Column(name ="enterprise")
    public String enterprise;

    @Column(name ="comment")
    public String comment = "a";

    // @ManyToOne
    // @JoinColumn(name = "eventID")
    // public Event event;
    // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // public List<Event> events = new ArrayList<Event>();

    // Participant constructor
    public Participant(){} // For Hibernate

    public Participant(String firstName, String lastName, String email, String enterprise, String birthDate) { // For java
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
        //this.participantID = Objects.hash(firstName, lastName, email, enterprise, birthDate);
    }

    // Participant getters
    public int getId(){
        return this.participantID;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public String getEnterprise(){
        return this.enterprise;
    }

    public String getComment(){
        return this.comment;
    }

    // Participant setters
    // @Autowired
    public void setId(int participantID){
        this.participantID=participantID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public void setEnterprise(String enterprise){
        this.enterprise = enterprise;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    // Display detail of a participant
    public void displayParticipant(){
        System.out.println("ID: " + this.participantID);
        System.out.println("Participant first name " + this.firstName);
        System.out.println("Participant last name " + this.lastName);
        System.out.println("Participant email adress " + this.email);
        System.out.println("Participant birthdate " + this.birthDate);
        System.out.println("Participant enterprise " + this.enterprise);
        System.out.println("Participant comment " + this.comment);
    }
}
