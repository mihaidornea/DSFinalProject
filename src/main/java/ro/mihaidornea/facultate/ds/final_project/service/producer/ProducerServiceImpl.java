package ro.mihaidornea.facultate.ds.final_project.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.mihaidornea.facultate.ds.final_project.dto.ProducerDto;
import ro.mihaidornea.facultate.ds.final_project.entities.Producer;
import ro.mihaidornea.facultate.ds.final_project.repository.ProducerRepository;

@Service
public class ProducerServiceImpl implements ProducerService {

    private ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public boolean create(ProducerDto producerDto) {
        Producer producer = new Producer();
        producer.setName(producerDto.getName());
        producerRepository.save(producer);
        return true;
    }

    @Override
    public ProducerDto findByName(String name){
        Producer producer = producerRepository.findByName(name);
        ProducerDto producerDto = new ProducerDto(producer.getName());
        return producerDto;
    }

    @Override
    public boolean existsByName(String producerName) {
        return producerRepository.existsByName(producerName);
    }

    @Override
    public int deleteByName(String producerName) {
        return producerRepository.deleteByName(producerName);
    }
}
