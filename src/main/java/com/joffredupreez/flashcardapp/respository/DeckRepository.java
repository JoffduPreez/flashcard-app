package com.joffredupreez.flashcardapp.respository;

import com.joffredupreez.flashcardapp.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
