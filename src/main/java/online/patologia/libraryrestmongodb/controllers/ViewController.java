package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String addNewBook(Model model) {
        model.addAttribute("books",bookService.findAll());
        return "index";
    }
}
