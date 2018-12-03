package ro.mihaidornea.facultate.ds.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mihaidornea.facultate.ds.final_project.entities.Genre;

import javax.transaction.Transactional;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> findById(Long id);
    Genre findByName(String name);
    boolean existsByName(String genreName);
    @Transactional
    int deleteByName(String genreName);
}
