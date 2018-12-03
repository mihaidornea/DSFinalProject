package ro.mihaidornea.facultate.ds.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.mihaidornea.facultate.ds.final_project.dto.ProducerDto;
import ro.mihaidornea.facultate.ds.final_project.messages.Message;
import ro.mihaidornea.facultate.ds.final_project.service.producer.ProducerService;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProducerController {


    private ProducerService producerService;
    private AtomicInteger counter;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/saveProducer")
    public Message saveProducer(@RequestParam(value =  "producerName") String name){
        ProducerDto producerDto = new ProducerDto(name);
        producerService.create(producerDto);
        return new Message(counter.incrementAndGet(), "You Created the Producer: " + name);
    }

    @GetMapping("/existsProducer")
    public Message existsProducer(@RequestParam String producerName){
        return new Message(counter.incrementAndGet(), "Exists: " + producerService.existsByName(producerName));
    }

    @GetMapping("/findProducer")
    public Message findProducer(@RequestParam String producerName){
        ProducerDto producerDto = producerService.findByName(producerName);
        return new Message(counter.incrementAndGet(), producerDto.toString());
    }

    @PostMapping("/deleteProducer")
    public Message deleteProducer(@RequestParam String producerName){
        producerService.deleteByName(producerName);
        return new Message(counter.incrementAndGet(), "You have deleted the producer: " + producerName);
    }
}
