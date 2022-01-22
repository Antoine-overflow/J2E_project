package com.example.servingwebcontent;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EventTest {
    
    @Test
    public void testEventConstructor(){
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
        Event CEOinvesture = new Event(title,theme,startingDate,length,nbMaxParticipant,description,organizer,type);
        Assert.assertEquals(CEOinvesture.getTitle(), title);
        Assert.assertEquals(CEOinvesture.getTheme(), theme);
        Assert.assertEquals(CEOinvesture.getStartingDate(), startingDate);
        Assert.assertEquals(CEOinvesture.getLength(), length);
        Assert.assertEquals(CEOinvesture.getNbMaxParticipant(), nbMaxParticipant);
        Assert.assertEquals(CEOinvesture.getDescription(), description);
        Assert.assertEquals(CEOinvesture.getOrganizer(), organizer);
        Assert.assertEquals(CEOinvesture.getType(), type);
    }

    @Test
    public void testAddParticipant(){
        Calendar birthDateJ = Calendar.getInstance();
        birthDateJ.set(1998-1900,21,2);
        Participant jules = new Participant("Jules", "Pierrat", "jules.pierrat@gmail.com", "Apple", birthDateJ);

        Calendar birthDateA = Calendar.getInstance();
        birthDateA.set(2001-1900,2,2);
        Participant antoine = new Participant("Antoine", "Rainaud", "antoine.rainaud@gmail.com", "Microsoft", birthDateA);

        Calendar birthDatePA = Calendar.getInstance();
        birthDatePA.set(1999-1900,1,2);
        Participant PA = new Participant("PA", "Orain", "pa.orain@gmail.com", "Pôle Emploi", birthDatePA);

        Calendar birthDateMS = Calendar.getInstance();
        birthDateMS.set(1998-1900,3,2);
        Participant MS = new Participant("MS", "Gabarnie", "ms.gaba@gmail.com", "JulesPierratEIRL", birthDateMS);

        Calendar startingDate = Calendar.getInstance();
        startingDate.set(2022-1900,15,2);
        Event anniv = new Event("anniv", "anniversaire", startingDate, 1, 3, "anniversaire de Jules et moi", jules, "anniversaire");

        List<Participant> participants = new ArrayList<Participant>();
        participants.add(jules);
        participants.add(antoine);
        anniv.addParticipant(antoine);

        Assert.assertEquals(anniv.getParticipants(), participants);
        Assert.assertEquals(anniv.getNbParticipant(), 2);

        participants.add(PA);
        anniv.addParticipant(PA);

        Assert.assertEquals(anniv.getParticipants(), participants);
        Assert.assertEquals(anniv.getNbParticipant(), 3);

        anniv.addParticipant(MS);
        Assert.assertEquals(anniv.getParticipants(), participants);
        Assert.assertEquals(anniv.getNbParticipant(), 3);
    }
}