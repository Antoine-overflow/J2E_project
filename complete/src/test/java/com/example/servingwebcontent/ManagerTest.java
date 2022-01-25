package com.example.servingwebcontent;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.servingwebcontent.Metier.Event;
import com.example.servingwebcontent.Metier.Manager;
import com.example.servingwebcontent.Metier.Participant;

public class ManagerTest {

    @Test
    public void testManagerConstructor(){
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Manager app = new Manager(events, participants);
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
        Event CEOinvesture = new Event(title, theme ,startingDate ,length ,nbMaxParticipant ,description ,organizer ,type);

        // Manager creation
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Manager app = new Manager(events, participants);

        Event e = app.createEvent(title, theme, startingDate, length, nbMaxParticipant, description, organizer, type);

        testEventEquality(e, CEOinvesture);
        Assert.assertEquals(app.getEvents().size(),1);
        Assert.assertEquals(app.getParticipants().size(),1);
    }
    
    @Test
    public void testCreateParticipant(){
        // Participant creation
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1967-1900,19,8);
        Participant satya = new Participant("Satya", "Nadella", "Satya.Nadella@microsoft.com", "Microsoft", birthDate);
        
        // Manager creation
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Manager app = new Manager(events, participants);

        Participant satya2 = app.createParticipant("Satya", "Nadella", "Satya.Nadella@microsoft.com", "Microsoft", birthDate);

        testPartcipantEquality(satya, satya2);
        Assert.assertEquals(app.getParticipants().size(), 1);
    }

    @Test
    public void testListEvents(){
        // Manager creation
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Manager app = new Manager(events, participants);

        // Event creation
        Calendar startingDate = Calendar.getInstance();
        startingDate.set(2022-1900,2,2);
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1967-1900,19,8);
        Participant organizer = new Participant("Satya", "Nadella", "Satya.Nadella@microsoft.com", "Microsoft", birthDate);
        Event CEOinvesture = app.createEvent("new CEO investure", "investure" ,startingDate ,1 ,1000000 ,"Investure of ower new CEO" ,organizer ,"investure");

        Calendar birthDateJ = Calendar.getInstance();
        birthDateJ.set(1998,2-1,21);
        Participant jules = new Participant("Jules", "Pierrat", "jules.pierrat@gmail.com", "Apple", birthDateJ);
        Calendar startingDate2 = Calendar.getInstance();
        startingDate.set(2022,2-1,15);
        Event anniv = app.createEvent("anniv", "anniversaire", startingDate2, 1, 3, "anniversaire de Jules et moi", jules, "anniversaire");

        List<String> titles = app.listEvents(false);
        List<String> titles2 = new ArrayList<String>();
        titles2.add(CEOinvesture.getTitle());
        titles2.add(anniv.getTitle());
        Assert.assertEquals(titles2, titles);
        List<String> titles3 = app.listEvents(true);
    }

    @Test
    public void testListParticipants(){
        // Manager creation
        List<Event> events = new ArrayList<Event>();
        List<Participant> participants = new ArrayList<Participant>();
        Manager app = new Manager(events, participants);

        // Event creation
        Calendar birthDateJ = Calendar.getInstance();
        birthDateJ.set(1998,2-1,21);
        Participant jules = new Participant("Jules", "Pierrat", "jules.pierrat@gmail.com", "Apple", birthDateJ);
        Calendar startingDate = Calendar.getInstance();
        startingDate.set(2022,2-1,15);
        Event anniv = app.createEvent("anniv", "anniversaire", startingDate, 1, 3, "anniversaire de Jules et moi", jules, "anniversaire");

        List<List<String>> names = app.listParticipants(anniv, false);
        List<List<String>> names2 = new ArrayList<List<String>>();
        List<String> firstNames = new ArrayList<String>();
        firstNames.add(jules.getFirstName());
        List<String> lastNames = new ArrayList<String>();
        lastNames.add(jules.getLastName());
        names2.add(firstNames);
        names2.add(lastNames);
        Assert.assertEquals(names, names2);
        List<List<String>> names3 = app.listParticipants(anniv, true);
    }
}
