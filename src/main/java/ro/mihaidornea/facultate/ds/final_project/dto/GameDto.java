package ro.mihaidornea.facultate.ds.final_project.dto;

import lombok.*;

import java.util.Set;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {


    private String name;
    private ProducerDto producerDto;
    private Set<GenreDto> genresDto;
    private float price;
    private String description;

}

