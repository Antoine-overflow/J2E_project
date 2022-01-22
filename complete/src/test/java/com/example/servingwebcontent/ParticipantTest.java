package com.example.servingwebcontent;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class ParticipantTest {
    
    @Test
    public void testParticipantConstructor(){
        String firstName = "Antoine";
        String lastName = "Rainaud";
        String email = "antoine.rainaud@gmail.com";
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2001-1900,2,2);
        String enterprise = "Microsoft";
        Participant moi = new Participant(firstName, lastName, email, enterprise, birthDate);
        Assert.assertEquals(moi.getFirstName(), firstName);
        Assert.assertEquals(moi.getLastName(), lastName);
        Assert.assertEquals(moi.getEmail(), email);
        Assert.assertEquals(moi.getEnterprise(), enterprise);
        Assert.assertEquals(moi.getBirthDate(), birthDate);
    }
}
