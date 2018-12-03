package ro.mihaidornea.facultate.ds.final_project.service.game;

import ro.mihaidornea.facultate.ds.final_project.dto.GameDto;

public interface GameService {

    boolean create(GameDto gameDto);

    GameDto findByName(String gameName);

    boolean existsByName(String gameName);

    int deleteGameByName(String gameName);
}
