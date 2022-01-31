package com.example.servingwebcontent.Metier;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EventTest {
    
    @Test
    public void testEventConstructor(){
        String title = "new CEO investure";
        String theme = "investure";
        String startingDate = "2022-2-2";
        int length = 1;
        int nbMaxParticipant = 1000000;
        String description = "Investure of ower new CEO";
        String birthDate = "1967-8-19";
        Participant organizer = new Participant("Satya", "Nadella", "Satya.Nadella@microsoft.com", "Microsoft", birthDate);
        String type = "investure";
        Event CEOinvesture = new Event(title,theme,type,startingDate,length,organizer,nbMaxParticipant,description);
        Assert.assertEquals(CEOinvesture.getTitle(), title);
        Assert.assertEquals(CEOinvesture.getTheme(), theme);
        Assert.assertEquals(CEOinvesture.getStartingDate(), startingDate);
        Assert.assertEquals(CEOinvesture.getLength(), length);
        Assert.assertEquals(CEOinvesture.getNbMaxParticipant(), nbMaxParticipant);
        Assert.assertEquals(CEOinvesture.getDescription(), description);
        Assert.assertEquals(CEOinvesture.getOrganizer(), organizer);
        Assert.assertEquals(CEOinvesture.getType(), type);
    }

    // @Test
    // public void testAddParticipant(){
    //     String birthDateJ = "1998-2-21";
    //     Participant jules = new Participant("Jules", "Pierrat", "jules.pierrat@gmail.com", "Apple", birthDateJ);

    //     String birthDateA = "2001,2,2";
    //     Participant antoine = new Participant("Antoine", "Rainaud", "antoine.rainaud@gmail.com", "Microsoft", birthDateA);

    //     String birthDatePA = "1999-2-1";
    //     Participant PA = new Participant("PA", "Orain", "pa.orain@gmail.com", "Pôle Emploi", birthDatePA);

    //     String birthDateMS = "1998-3-2";
    //     Participant MS = new Participant("MS", "Gabarnie", "ms.gaba@gmail.com", "JulesPierratEIRL", birthDateMS);

    //     String startingDate = "2022-2-15";
    //     Event anniv = new Event("anniv", "anniversaire", startingDate, 1, 3, "anniversaire de Jules et moi", jules, "anniversaire");

    //     List<Participant> participants = new ArrayList<Participant>();
    //     participants.add(jules);
    //     participants.add(antoine);
    //     anniv.addParticipant(antoine);

    //     Assert.assertEquals(anniv.getParticipants(), participants);
    //     Assert.assertEquals(anniv.getNbParticipant(), 2);

    //     participants.add(PA);
    //     anniv.addParticipant(PA);

    //     Assert.assertEquals(anniv.getParticipants(), participants);
    //     Assert.assertEquals(anniv.getNbParticipant(), 3);

    //     anniv.addParticipant(MS);
    //     Assert.assertEquals(anniv.getParticipants(), participants);
    //     Assert.assertEquals(anniv.getNbParticipant(), 3);
    // }

    @Test
    public void testDisplayEvent(){
        String birthDateMS = "1998-3-2";
        Participant MS = new Participant("MS", "Gabarnie", "ms.gaba@gmail.com", "JulesPierratEIRL", birthDateMS);

        String startingDate = "2022-2-15";
        Event anniv = new Event("anniv", "anniversaire", "anniversaire", startingDate, 1, MS, 3, "anniversaire de Jules et moi");
        anniv.displayEvent();
    }
}
