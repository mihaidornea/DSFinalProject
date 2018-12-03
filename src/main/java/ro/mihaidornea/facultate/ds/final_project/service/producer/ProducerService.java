package ro.mihaidornea.facultate.ds.final_project.service.producer;

import ro.mihaidornea.facultate.ds.final_project.dto.ProducerDto;

public interface ProducerService {

    boolean create(ProducerDto producerDto);
    ProducerDto findByName(String name);
    boolean existsByName(String producerName);
    int deleteByName(String producerName);

}
