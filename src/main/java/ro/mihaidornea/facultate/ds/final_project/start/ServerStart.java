package ro.mihaidornea.facultate.ds.final_project.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ro.mihaidornea.facultate.ds.final_project.controllers")
@EnableJpaRepositories("ro.mihaidornea.facultate.ds.final_project.repository")
@ComponentScan("ro.mihaidornea.facultate.ds.final_project.service.game")
@ComponentScan("ro.mihaidornea.facultate.ds.final_project.service.producer")
@ComponentScan("ro.mihaidornea.facultate.ds.final_project.service.genre")
@EntityScan("ro.mihaidornea.facultate.ds.final_project.entities")
@ComponentScan("ro.mihaidornea.facultate.ds.final_project.messages")
public class ServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ServerStart.class, args);
    }
}
