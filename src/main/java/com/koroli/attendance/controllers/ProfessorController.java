package com.koroli.attendance.controllers;

import com.koroli.attendance.data.dto.ProfessorDto;
import com.koroli.attendance.data.forms.ProfessorForm;
import com.koroli.attendance.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping()
    public ProfessorDto createProfessor(@RequestBody ProfessorForm form) {
        return professorService.createProfessor(form);
    }

    @GetMapping("/{id}")
    public ProfessorDto getProfessor(@PathVariable UUID id) {
        return professorService.getProfessor(id);
    }

    @GetMapping()
    public List<ProfessorDto> getAllProfessors() {
        return professorService.getAllProfessor();
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable UUID id) {
        professorService.deleteProfessor(id);
    }
}