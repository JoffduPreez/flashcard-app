package com.joffredupreez.flashcardapp;

import com.joffredupreez.flashcardapp.deck.Deck;
import com.joffredupreez.flashcardapp.service.JpaAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCmdLineRunner implements CommandLineRunner {
    private static final Logger log =
            LoggerFactory.getLogger(ApplicationCmdLineRunner.class);

    @Autowired
    private JpaAccess jpaAccess;
    public void run(String... arg0) throws Exception {
        Deck deck = new Deck(1, "MATH*1200 reivew", "Test description");
        jpaAccess.save(deck);
        log.info("New Deck is created : " + deck);

        Deck deck2 = new Deck(2, "Coding flashcards", "Coding flashcards description");
        jpaAccess.save(deck2);
        log.info("Deck 2 created : " + deck2);

        Deck deck3 = new Deck(3, "Keg menu flashcards", "Keg menu flashcards description");
        jpaAccess.save(deck3);
        log.info("Deck 3 created : " + deck3);

    }
}
