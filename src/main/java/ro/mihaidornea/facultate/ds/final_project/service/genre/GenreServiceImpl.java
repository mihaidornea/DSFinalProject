package ro.mihaidornea.facultate.ds.final_project.service.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaidornea.facultate.ds.final_project.dto.GenreDto;
import ro.mihaidornea.facultate.ds.final_project.entities.Genre;
import ro.mihaidornea.facultate.ds.final_project.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public boolean create(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setName(genreDto.getName());
        genreRepository.save(genre);
        return true;
    }

    @Override
    public GenreDto findByName(String name) {
        Genre genre = genreRepository.findByName(name);
        GenreDto genreDto = new GenreDto(genre.getName());
        return genreDto;
    }

    @Override
    public boolean existsByName(String genreName) {
        return genreRepository.existsByName(genreName);
    }

    @Override
    public int deleteByName(String genreName) {
        return genreRepository.deleteByName(genreName);
    }
}
