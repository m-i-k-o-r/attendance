package com.koroli.attendance.controllers;

import com.koroli.attendance.data.dto.DisciplineDto;
import com.koroli.attendance.data.forms.DisciplineForm;
import com.koroli.attendance.data.forms.ScheduleForm;
import com.koroli.attendance.services.DisciplineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    @Tag(name = "discipline")
    @PostMapping()
    public DisciplineDto createDiscipline(@RequestBody DisciplineForm form) {
        return disciplineService.createDiscipline(form);
    }

    @Tag(name = "discipline")
    @GetMapping("/check")
    public List<DisciplineDto> hasDiscipline(@RequestParam UUID professorId,
                                             @RequestParam LocalDateTime timeNow) {
        return disciplineService.hasDiscipline(professorId, timeNow);
    }

    @Tag(name = "discipline")
    @GetMapping("/{id}")
    public DisciplineDto getDiscipline(@PathVariable UUID id) {
        return disciplineService.getDiscipline(id);
    }

    @Tag(name = "discipline")
    @GetMapping()
    public List<DisciplineDto> getAllDisciplines() {
        return disciplineService.getAllDiscipline();
    }

    @Tag(name = "discipline")
    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable UUID id) {
        disciplineService.deleteDiscipline(id);
    }

    @Tag(name = "schedule")
    @PostMapping("/{id}/create-schedule")
    public DisciplineDto createSchedule(@PathVariable UUID id,
                                        @RequestBody ScheduleForm form) {
        return disciplineService.createSchedule(id, form);
    }

    @Tag(name = "schedule")
    @PutMapping("/{id}/update-schedule/{scheduleId}")
    public DisciplineDto updateSchedule(@PathVariable UUID id,
                                        @PathVariable UUID scheduleId,
                                        @RequestBody ScheduleForm form) {
        return disciplineService.updateSchedule(id, scheduleId, form);
    }

    @Tag(name = "schedule")
    @DeleteMapping("/{id}/delete-schedule/{scheduleId}")
    public DisciplineDto deleteSchedule(@PathVariable UUID id,
                                        @PathVariable UUID scheduleId) {
        return disciplineService.deleteSchedule(id, scheduleId);
    }
}