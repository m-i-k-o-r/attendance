package com.koroli.attendance.services;

import com.koroli.attendance.data.dto.ProfessorDto;
import com.koroli.attendance.data.forms.ProfessorForm;
import com.koroli.attendance.data.mappers.ProfessorMapper;
import com.koroli.attendance.exceptions.NotFoundException;
import com.koroli.attendance.models.Professor;
import com.koroli.attendance.repos.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorDto createProfessor(ProfessorForm form) {
        return ProfessorMapper.INSTANCE.toDto(professorRepository.save(Professor.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .fullName(form.getFullName())
                .build()));
    }

    /*public ProfessorDto updateProfessor(UUID id, ProfessorForm form) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Professor with this id not found"));
        //...
        return ProfessorMapper.INSTANCE.toDto(professorRepository.save(professor));
    }*/

    public ProfessorDto getProfessor(UUID id) {
        return ProfessorMapper.INSTANCE.toDto(professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Professor with this id not found")));
    }

    public List<ProfessorDto> getAllProfessor() {
        return ProfessorMapper.INSTANCE.toDto(professorRepository.findAll());
    }

    public void deleteProfessor(UUID id) {
        professorRepository.delete(professorRepository.findById(id).orElseThrow(() -> new NotFoundException("Professor with this id not found")));
    }
}

