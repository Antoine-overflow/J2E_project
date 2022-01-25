package com.example.servingwebcontent.Metier;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ParticipantTest {
    
    @Test
    public void testParticipantConstructor(){
        String firstName = "Antoine";
        String lastName = "Rainaud";
        String email = "antoine.rainaud@gmail.com";
        String birthDate = "2001-2-2";
        String enterprise = "Microsoft";
        Participant moi = new Participant(firstName, lastName, email, enterprise, birthDate);
        Assert.assertEquals(moi.getFirstName(), firstName);
        Assert.assertEquals(moi.getLastName(), lastName);
        Assert.assertEquals(moi.getEmail(), email);
        Assert.assertEquals(moi.getEnterprise(), enterprise);
        Assert.assertEquals(moi.getBirthDate(), birthDate);
    }

    @Test
    public void testDisplayParticipant(){
        String birthDate = "2001-2-2";
        Participant moi = new Participant("antoine", "rainaud", "antoine.rainaud@gmail.com", "Microsoft", birthDate);
        moi.displayParticipant();
    }
}
