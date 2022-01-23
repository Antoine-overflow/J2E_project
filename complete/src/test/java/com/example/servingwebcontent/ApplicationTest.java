package com.example.servingwebcontent;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ApplicationTest {

    @Test
    public void testApplicationConstructor(){
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Application app = new Application(events, participants);
        Assert.assertEquals(app.getEvents(),events);
        Assert.assertEquals(app.getParticipants(),participants);
    }
    
    public void testPartcipantEquality(Participant p1, Participant p2){
        Assert.assertEquals(p1.getFirstName(), p2.getFirstName());
        Assert.assertEquals(p1.getLastName(),p2.getLastName());
        Assert.assertEquals(p1.getEmail(), p2.getEmail());
        Assert.assertEquals(p1.getBirthDate(), p2.getBirthDate());
        Assert.assertEquals(p1.getEnterprise(), p2.getEnterprise());
    }

    public void testEventEquality(Event e1, Event e2){
        Assert.assertEquals(e1.getTitle(), e2.getTitle());
        Assert.assertEquals(e1.getTheme(), e2.getTheme());
        Assert.assertEquals(e1.getStartingDate(), e2.getStartingDate());
        Assert.assertEquals(e1.getLength(), e2.getLength());
        Assert.assertEquals(e1.getNbMaxParticipant(), e2.getNbMaxParticipant());
        testPartcipantEquality(e1.getOrganizer(), e2.getOrganizer());
        Assert.assertEquals(e1.getDescription(), e2.getDescription());
        Assert.assertEquals(e1.getType(), e2.getType());
    }

    @Test
    public void testCreateEvent(){
        // Event creation
        String title = "new CEO investure";
        String theme = "investure";
        Calendar startingDate = Calendar.getInstance();
        startingDate.set(2022-1900,2,2);
        int length = 1;
        int nbMaxParticipant = 1000000;
        String description = "Investure of ower new CEO";
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1967-1900,19,8);
        Participant organizer = new Participant("Satya", "Nadella", "Satya.Nadella@microsoft.com", "Microsoft", birthDate);
        String type = "investure";

        // Application creation
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Application app = new Application(events, participants);

        Event e = app.createEvent(title, theme, startingDate, length, nbMaxParticipant, description, organizer, type);
        Event CEOinvesture = new Event(title, theme ,startingDate ,length ,nbMaxParticipant ,description ,organizer ,type);

        testEventEquality(e, CEOinvesture);
        Assert.assertEquals(app.getEvents().size(),1);
        Assert.assertEquals(app.getParticipants().size(),1);
    }
    
}
