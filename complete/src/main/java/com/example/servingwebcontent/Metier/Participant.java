package com.example.servingwebcontent.Metier;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Embeddable
@Table(name = "Participants")
public class Participant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name ="first_name")
    public String firstName;

    @Column(name ="last_name")
    public String lastName;

    @Column(name ="email")
    public String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="birthDate")
    public String birthDate;

    @Column(name ="enterprise")
    public String enterprise;

    @Column(name ="comment")
    public String comment = "";

    // Participant constructor
    public Participant(){} // For Hibernate

    public Participant(String firstName, String lastName, String email, String enterprise, String birthDate){ // For java
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
    }

    // Participant getters
    public long getId(){
        return this.id;
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
        System.out.println("Participant first name " + this.firstName);
        System.out.println("Participant last name " + this.lastName);
        System.out.println("Participant email adress " + this.email);
        System.out.println("Participant birthdate " + this.birthDate);
        System.out.println("Participant enterprise " + this.enterprise);
    }
}
