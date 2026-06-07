package com.example.studentapi.service;

import com.example.studentapi.dto.CoursRequestDTO;
import com.example.studentapi.dto.CoursResponseDTO;
import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Student;
import com.example.studentapi.exception.ResourceNotFoundException;
import com.example.studentapi.mapper.CoursMapper;
import com.example.studentapi.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoursService {

    private final CoursRepository coursRepository;
    private final CoursMapper coursMapper;

    public CoursService(CoursRepository coursRepository, CoursMapper coursMapper) {
        this.coursRepository = coursRepository;
        this.coursMapper = coursMapper;
    }

    public CoursResponseDTO addCours(CoursRequestDTO dto){
        Cours cours = coursMapper.toEntity(dto);
        Cours savedCours = coursRepository.save(cours);
        return coursMapper.toResponseDTO(savedCours);
    }
    public List<CoursResponseDTO> getAllCours(){
        return coursRepository.findAll()
                .stream()
                .map(coursMapper::toResponseDTO)
                .toList();
    }


    public CoursResponseDTO getCoursById(Long id){
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cours introuvable avec l'id : " + id));
        return coursMapper.toResponseDTO(cours);
    }

    public CoursResponseDTO updateCours(Long id, CoursRequestDTO dto){
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cours introuvable avec l'id " + id));

        coursMapper.updateEntityFromDTO(dto, cours);
        Cours updatedCours = coursRepository.save(cours);
        return coursMapper.toResponseDTO(updatedCours);
    }

    public void deleteCours(Long id){
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cours introuvable avec l'id : " + id));
        coursRepository.delete(cours);
    }

    public List<Student> getStudentByCours(Long coursId){
        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new ResourceNotFoundException("Cours introuvable avec l'id : " + coursId));

        return cours.getStudents();
    }

    public List<CoursResponseDTO> getCoursBetweenDates(
            Date debut,
            Date fin){

        return coursRepository
                .findByDateBetween(debut, fin)
                .stream()
                .map(coursMapper::toResponseDTO)
                .toList();
    }
}
