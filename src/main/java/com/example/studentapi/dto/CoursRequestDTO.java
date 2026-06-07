package com.example.studentapi.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CoursRequestDTO(

        @NotBlank(message = "le titre est obligatoire")
        String titre,

        @NotBlank(message = "la description est obligatoire")
        String description,

        @NotNull(message = "La date de début est obligatoire")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date dateDebut,

        @NotNull(message = "La date de fin est obligatoire")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date dateFin
) {
}
