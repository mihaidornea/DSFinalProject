package ro.mihaidornea.facultate.ds.final_project.service.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaidornea.facultate.ds.final_project.dto.GameDto;
import ro.mihaidornea.facultate.ds.final_project.dto.GenreDto;
import ro.mihaidornea.facultate.ds.final_project.dto.ProducerDto;
import ro.mihaidornea.facultate.ds.final_project.entities.Game;
import ro.mihaidornea.facultate.ds.final_project.entities.Genre;
import ro.mihaidornea.facultate.ds.final_project.entities.Producer;
import ro.mihaidornea.facultate.ds.final_project.repository.GameRepository;
import ro.mihaidornea.facultate.ds.final_project.repository.ProducerRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService{

    private GameRepository gameRepository;
    private ProducerRepository producerRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ProducerRepository producerRepository) {
        this.gameRepository = gameRepository;
        this.producerRepository = producerRepository;
    }

    @Override
    public boolean create(GameDto gameDto) {
        Producer producer = producerRepository.findByName(gameDto.getProducerDto().getName());
        Game game = new Game();
        game.setName(gameDto.getName());
        game.setProducer(producer);
        Set<GenreDto> genresDto = gameDto.getGenresDto();
        Set<Genre> genres = new HashSet<>();
        for (GenreDto genreDto : genresDto){
            Genre genre = new Genre();
            genre.setName(genreDto.getName());
            genres.add(genre);
        }
        game.setGenres(genres);
        gameRepository.save(game);
        return true;
    }

    @Override
    public GameDto findByName(String gameName){
        Game game = gameRepository.findByName(gameName);
        ProducerDto producerDto = new ProducerDto(game.getProducer().getName());
        Set<GenreDto> genreDtos = new HashSet<>();
        for (Genre genre : game.getGenres()){
            genreDtos.add(new GenreDto(genre.getName()));
        }
        GameDto gameDto = new GameDto(game.getName(), producerDto, genreDtos, game.getPrice(), game.getDescription());
        return gameDto;
    }

    @Override
    public boolean existsByName(String gameName) {
        return gameRepository.existsByName(gameName);
    }

    @Override
    public int deleteGameByName(String gameName) {
        return gameRepository.deleteGameByName(gameName);
    }
}
