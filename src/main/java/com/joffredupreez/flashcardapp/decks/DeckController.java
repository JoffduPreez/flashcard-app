package com.joffredupreez.flashcardapp.decks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeckController {

    @RequestMapping(path = "decks")
    public String getDeckPage () {
        return "decks";
    }
}
