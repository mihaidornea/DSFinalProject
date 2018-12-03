package ro.mihaidornea.facultate.ds.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mihaidornea.facultate.ds.final_project.entities.Game;

import javax.transaction.Transactional;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findById(Long id);
    Game findByName(String name);
    boolean existsByName(String name);
    @Transactional
    int deleteGameByName(String gameName);
    
}
