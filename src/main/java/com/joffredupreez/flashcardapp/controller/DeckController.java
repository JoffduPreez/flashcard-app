package com.joffredupreez.flashcardapp.controller;

import com.joffredupreez.flashcardapp.model.Deck;
import com.joffredupreez.flashcardapp.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeckController {
    @Autowired
    private DeckService deckService;

    @RequestMapping(path = "decks", method = RequestMethod.GET)
    public String loadDeckPage (ModelMap model) {
        List<Deck> decks = deckService.getAllDecks();
        model.addAttribute("decks", decks);

        return "decks";
    }


    @RequestMapping(path = "addDeck", method = RequestMethod.GET)
    public String loadAddDeckPage () {
        return "addDeck";
    }


    @RequestMapping(path = "editDeck", method = RequestMethod.GET)
    public String loadEditDeckPage (ModelMap model, @RequestParam Long id) {
        model.addAttribute("deck", deckService.getDeck(id));

        return "editDeck";
    }


    @RequestMapping(path = "addDeck", method = RequestMethod.POST)
    public String createNewDeck (@RequestBody MultiValueMap<String, String> formData) {
        deckService.createDeck(formData.getFirst("title"), formData.getFirst("description"));

        return "redirect:decks";
    }


    @RequestMapping(path = "editDeck", method = RequestMethod.PUT)
    public ResponseEntity<Void> editDeck (@RequestBody Deck deck) {
        deckService.editDeck(deck.getId(), deck.getTitle(), deck.getDescription());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(path = "deleteDeck", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDeck (@RequestParam Long id) {
        System.out.println("id = " + id);
        deckService.deleteDeck(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
