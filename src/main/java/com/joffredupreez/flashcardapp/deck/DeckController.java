package com.joffredupreez.flashcardapp.deck;

import com.joffredupreez.flashcardapp.service.DeckJpaAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DeckController {
    @Autowired
//    private DeckJpaAccess jpaAccess;
    private DeckService deckService;

    @RequestMapping(path = "deck", method = RequestMethod.GET)
    public String loadDeckPage (ModelMap model) {
        List<Deck> decks = deckService.getAll();
        model.addAttribute("decks", decks);

        return "deck";
    }

    @RequestMapping(path = "addDeck", method = RequestMethod.GET)
    public String loadAddDeckPage () {
        return "addDeck";
    }

    @RequestMapping(path = "addDeck", method = RequestMethod.POST)
    public String createNewDeck (@RequestBody MultiValueMap<String, String> formData) {
        deckService.createDeck(formData.getFirst("title"), formData.getFirst("description"));

        return "redirect:deck";
    }

    @RequestMapping(path = "deleteDeck", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDeck (@RequestParam Long id) {
        System.out.println("id = " + id);
        deckService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
