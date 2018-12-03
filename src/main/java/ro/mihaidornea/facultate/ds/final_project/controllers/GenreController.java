package ro.mihaidornea.facultate.ds.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.mihaidornea.facultate.ds.final_project.dto.GenreDto;
import ro.mihaidornea.facultate.ds.final_project.messages.Message;
import ro.mihaidornea.facultate.ds.final_project.service.genre.GenreService;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GenreController {

    private GenreService genreService;
    private AtomicInteger counter;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/saveGenre")
    public Message saveGenre (@RequestParam String genreName){
        GenreDto genreDto = new GenreDto(genreName);
        genreService.create(genreDto);
        return new Message(counter.incrementAndGet(), "You just saved the genre " + genreName);
    }

    @GetMapping("/existsGenre")
    public Message existsGenre (@RequestParam String genreName){
        return new Message(counter.incrementAndGet(), "Exists: " + genreService.existsByName(genreName));
    }

    @GetMapping("/findGenre")
    public Message findGenre (@RequestParam String genreName){
        GenreDto genreDto = genreService.findByName(genreName);
        return new Message(counter.incrementAndGet(), genreDto.toString());
    }

    @PostMapping("/deleteGenre")
    public Message deleteGenre (@RequestParam String genreName){
        genreService.deleteByName(genreName);
        return new Message(counter.incrementAndGet(), "You deleted the genre: " + genreName);
    }

    //TODO update

}
