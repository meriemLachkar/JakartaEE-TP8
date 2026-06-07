package com.example.studentapi.controller;

import com.example.studentapi.dto.CoursRequestDTO;
import com.example.studentapi.dto.CoursResponseDTO;
import com.example.studentapi.entity.Student;
import com.example.studentapi.service.CoursService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final CoursService coursService;


    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoursResponseDTO addCours(@Valid @RequestBody CoursRequestDTO dto){
        return coursService.addCours(dto);
    }

    @GetMapping
    public List<CoursResponseDTO> getAllCours(){
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public CoursResponseDTO getCoursById(@PathVariable Long id){
        return coursService.getCoursById(id);
    }

    @PutMapping("/{id}")
    public CoursResponseDTO updateCours(@PathVariable Long id, @Valid @RequestBody CoursRequestDTO dto){
        return coursService.updateCours(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCours(@PathVariable Long id){
        coursService.deleteCours(id);
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentByCours(@PathVariable Long id){
        return coursService.getStudentByCours(id);
    }

    @GetMapping("/disponible")
    public List<CoursResponseDTO> getCoursBetweenDates(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date debut,

            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date fin){
        return coursService.getCoursBetweenDates(debut, fin);
    }
}
