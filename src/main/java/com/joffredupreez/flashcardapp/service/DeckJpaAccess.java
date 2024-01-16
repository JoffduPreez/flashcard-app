package com.joffredupreez.flashcardapp.service;

import com.joffredupreez.flashcardapp.deck.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckJpaAccess extends JpaRepository<Deck, Long> {
}
