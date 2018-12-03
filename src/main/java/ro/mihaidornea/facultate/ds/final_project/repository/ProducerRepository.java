package ro.mihaidornea.facultate.ds.final_project.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.mihaidornea.facultate.ds.final_project.entities.Producer;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Optional<Producer> findById(Long id);
    Producer findByName(String name);
    boolean existsByName(String producerName);
    @Transactional
    int deleteByName(String producerName);

}
