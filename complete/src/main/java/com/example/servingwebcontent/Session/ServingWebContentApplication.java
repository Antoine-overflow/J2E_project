package com.example.servingwebcontent.Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Service.EventService;
import com.example.servingwebcontent.Service.ParticipantService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServingWebContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);

        ParticipantService participantService = new ParticipantService();
        
        long a = participantService.create("Antoine","Rainaud","antoine@ensg.eu","2001-2-2","Microsoft");
        long b = participantService.create("Jules", "Pierrat", "jules@ensg.eu","1998-2-21","Google");

        EventService eventService = new EventService();

        Participant antoine = new Participant("Antoine","Rainaud","antoine@ensg.eu","2001-2-2","Microsoft");
        long b2 = eventService.create("birthday","party","2022-02-01",1,20,"Antoine and PA birthday",antoine,"party");
    }

}
