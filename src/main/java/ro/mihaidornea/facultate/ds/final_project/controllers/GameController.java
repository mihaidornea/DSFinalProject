package ro.mihaidornea.facultate.ds.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.mihaidornea.facultate.ds.final_project.dto.GameDto;
import ro.mihaidornea.facultate.ds.final_project.dto.GenreDto;
import ro.mihaidornea.facultate.ds.final_project.dto.ProducerDto;
import ro.mihaidornea.facultate.ds.final_project.messages.Message;
import ro.mihaidornea.facultate.ds.final_project.service.game.GameService;
import ro.mihaidornea.facultate.ds.final_project.service.genre.GenreService;
import ro.mihaidornea.facultate.ds.final_project.service.producer.ProducerService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GameController {

    private ProducerService producerService;
    private GenreService genreService;
    private GameService gameService;
    private AtomicInteger counter;

    @Autowired
    public GameController(ProducerService producerService, GenreService genreService, GameService gameService) {
        this.producerService = producerService;
        this.genreService = genreService;
        this.gameService = gameService;
    }

    @PostMapping("/saveGame")
    public Message saveGame (@RequestBody GameDto gameDto){

        ProducerDto producerDto = producerService.findByName(gameDto.getProducerDto().getName());
        //TODO validate this
        Set<GenreDto> genreDtos = new HashSet<>();
        for (GenreDto genreDto : gameDto.getGenresDto()){
            GenreDto dbGenreDto = genreService.findByName(genreDto.getName());
            if (dbGenreDto != null){
                genreDtos.add(genreDto);
            }
        }

        if (producerDto != null){
            GameDto dbGameDto = new GameDto(gameDto.getName(), producerDto, genreDtos, gameDto.getPrice(), gameDto.getDescription());
            gameService.create(dbGameDto);
            return new Message(counter.incrementAndGet(), "You have just saved a game named " + gameDto.getName() + " made by " + gameDto.getProducerDto().getName());
        } else {
            return new Message(counter.incrementAndGet(), "Error while finding the producer in the database!");
        }
    }

    @GetMapping("/findGame")
    public Message getGame (@RequestParam(name = "gameName") String gameName){
        GameDto gameDto = gameService.findByName(gameName);
        return new Message(counter.incrementAndGet(), gameDto.toString());
    }

    @GetMapping("/existsGame")
    public Message existsGame (@RequestParam(name = "gameName") String gameName){
        return new Message(counter.incrementAndGet(), "Exists: " + gameService.existsByName(gameName));
    }

    @PostMapping("/deleteGame")
    public Message deleteGame (@RequestParam(name = "gameName") String gameName){
        if (gameService.existsByName(gameName)){
            gameService.deleteGameByName(gameName);
            return new Message(counter.incrementAndGet(), "Deleted game!");
        } else {
            return new Message(counter.incrementAndGet(), "Game " + gameName + " does not exist!");
        }
    }

}
