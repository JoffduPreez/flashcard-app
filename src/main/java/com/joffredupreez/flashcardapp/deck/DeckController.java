package com.joffredupreez.flashcardapp.deck;

import com.joffredupreez.flashcardapp.service.JpaAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class DeckController {
    @Autowired
    private JpaAccess jpaAccess;

    @RequestMapping(path = "deck", method = RequestMethod.GET)
    public String loadDeckPage (ModelMap model) {
        List<Deck> decks = jpaAccess.findAll();
        model.addAttribute("decks", decks);

        return "deck";
    }
    @RequestMapping(path = "addDeck", method = RequestMethod.GET)
    public String loadAddDeckPage (ModelMap model) {
        return "addDeck";
    }

    @RequestMapping(path = "addDeck", method = RequestMethod.POST)
    public String createNewDeck (@RequestBody MultiValueMap<String, String> formData) {
        jpaAccess.save(new Deck(formData.getFirst("title"), formData.getFirst("description")));

        return "redirect:deck";
    }
}
