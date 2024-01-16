package com.joffredupreez.flashcardapp.deck;

import com.joffredupreez.flashcardapp.service.DeckJpaAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeckService {
    @Autowired
    private DeckJpaAccess jpaAccess;

    public List<Deck> getAll() {
        return jpaAccess.findAll();
    }

    public Optional<Deck> getById(Long id) {
        return jpaAccess.findById(id);
    }

    public void deleteById(Long id) {
        jpaAccess.deleteById(id);
    }

    public void createDeck(String title, String description) {
        jpaAccess.save(new Deck(title, description));
    }





    // return all decks
    // return 1 deck by id

}
