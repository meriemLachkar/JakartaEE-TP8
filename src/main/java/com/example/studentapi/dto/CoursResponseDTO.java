package com.example.studentapi.dto;

import java.util.Date;

public record CoursResponseDTO(
        Long id,
        String titre,
        String description,
        Date dateDebut,
        Date dateFin
) {
}
