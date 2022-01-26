package com.example.servingwebcontent.Metier;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Participants")
public class Participant {

    @Column(name = "identifier")
    @Id
    public long ID = 0;

    @Column(name ="first_name")
    public String firstName;

    @Column(name ="last_name")
    public String lastName;

    @Column(name ="email")
    public String email;

    @Column(name ="birthDate")
    public String birthDate;

    @Column(name ="enterprise")
    public String enterprise;

    @Column(name ="comment")
    public String comment = "";

    // Participant constructor
    public Participant(){} // For Hibernate

    public Participant(String firstName, String lastName, String email, String enterprise, String birthDate) { // For java
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
        this.ID = Math.abs(Objects.hash(firstName, lastName, email, enterprise, birthDate));
    }

    public Participant(String firstName, String lastName, String email, String enterprise, String birthDate, String comment) { // For java
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
        this.comment = comment;
        this.ID = Math.abs(Objects.hash(firstName, lastName, email, enterprise, birthDate));
    }

    // Participant getters
    public long getId(){
        return this.ID;
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
    public void setId(long id){
        this.ID = id;
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
        System.out.println("ID: " + this.ID);
        System.out.println("Participant first name " + this.firstName);
        System.out.println("Participant last name " + this.lastName);
        System.out.println("Participant email adress " + this.email);
        System.out.println("Participant birthdate " + this.birthDate);
        System.out.println("Participant enterprise " + this.enterprise);
        System.out.println("Participant comment " + this.comment);
    }
}
