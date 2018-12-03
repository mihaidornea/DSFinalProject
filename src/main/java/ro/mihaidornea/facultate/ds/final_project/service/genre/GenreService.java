package ro.mihaidornea.facultate.ds.final_project.service.genre;

import ro.mihaidornea.facultate.ds.final_project.dto.GenreDto;

public interface GenreService {

    boolean create(GenreDto genreDto);
    GenreDto findByName(String name);
    boolean existsByName(String genreName);
    int deleteByName(String genreName);

}
