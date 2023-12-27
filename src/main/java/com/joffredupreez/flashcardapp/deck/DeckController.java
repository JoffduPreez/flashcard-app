package com.joffredupreez.flashcardapp.deck;

import com.joffredupreez.flashcardapp.service.JpaAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeckController {
    @Autowired
    private JpaAccess jpaAccess;

    @RequestMapping(path = "deck")
    public String getDeckPage (ModelMap model) {
        List<Deck> decks = jpaAccess.findAll();
        model.addAttribute("decks", decks);

        return "deck";
    }
}
