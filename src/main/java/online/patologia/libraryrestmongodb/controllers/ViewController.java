package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @Autowired
    private SongService songService;

    @RequestMapping("/")
    public String addNewBook(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }
}
