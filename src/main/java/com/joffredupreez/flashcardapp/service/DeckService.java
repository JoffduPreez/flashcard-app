package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.model.Deck;

import com.joffredupreez.flashcardapp.respository.DeckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;
    private final Logger logger = LoggerFactory.getLogger(DeckService.class);


    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }


    public Deck getDeck(Long id) {
        Optional<Deck> optionalDeck = deckRepository.findById(id);
        Deck deck = null;
        if (optionalDeck.isPresent()) {
            deck = optionalDeck.get();
        } else {
            logger.error("Unable to find deck with the id of " + id);
        }

        return deck;
    }


    public void createDeck(String title, String description) {
        deckRepository.save(new Deck(title, description));
    }


    public void editDeck(Long id, String title, String description) {
        Deck deck = getDeck(id);
        deck.setTitle(title);
        deck.setDescription(description);
        deckRepository.save(deck);
    }


    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }
}
