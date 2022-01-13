package com.example.servingwebcontent;

public class Participant {

    public String firstName;
    public String lastName;
    public String email;
    public long birthDate;
    public String enterprise;
    public String comment = "";

    public Participant(String firstName,
     String lastName, String email, String enterprise,
      long birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enterprise = enterprise;
        this.birthDate = birthDate;
    }

    public Participant createParticipant(String firstName,
    String lastName, String email, String enterprise,
     long birthDate){
         return new Participant(firstName, lastName, email, enterprise, birthDate);
     }
}
