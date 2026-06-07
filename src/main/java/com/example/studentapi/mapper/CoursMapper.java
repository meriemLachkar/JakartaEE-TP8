package com.example.studentapi.mapper;

import com.example.studentapi.dto.CoursRequestDTO;
import com.example.studentapi.dto.CoursResponseDTO;
import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoursMapper {

    public Cours toEntity(CoursRequestDTO dto){
        Cours cours = new Cours();
        cours.setTitre(dto.titre());
        cours.setDescription(dto.description());
        cours.setDateDebut(dto.dateDebut());
        cours.setDateFin(dto.dateFin());
        return cours;
    }

    public CoursResponseDTO toResponseDTO(Cours cours){
        return new CoursResponseDTO(
                cours.getId(),
                cours.getTitre(),
                cours.getDescription(),
                cours.getDateDebut(),
                cours.getDateFin()
        );
    }

    public void updateEntityFromDTO(CoursRequestDTO dto, Cours cours){
        cours.setTitre(dto.titre());
        cours.setDescription(dto.description());
        cours.setDateDebut(dto.dateDebut());
        cours.setDateFin(dto.dateFin());
    }
}
