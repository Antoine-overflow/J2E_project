package com.example.servingwebcontent;

public class Participant {

    public String firstName;
    public String lastName;
    public String email;
    public long birthDate;
    public String enterprise;
    public String comment = "";

    // Participant constructor
    public Participant(String firstName, String lastName, String email, String enterprise, long birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
    }

    // Participant getters
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public long getBirthDate(){
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

    public void setBirthDate(long birthDate){
        this.birthDate = birthDate;
    }

    public void setEnterprise(String entreprise){
        this.enterprise = enterprise;
    }

    public void setComment(String comment){
        this.comment = comment;
    }
}
