package com.koroli.attendance.services;

import com.koroli.attendance.data.dto.DisciplineDto;
import com.koroli.attendance.data.forms.DisciplineForm;
import com.koroli.attendance.data.forms.ScheduleForm;
import com.koroli.attendance.data.mappers.DisciplineMapper;
import com.koroli.attendance.exceptions.NotFoundException;
import com.koroli.attendance.models.Discipline;
import com.koroli.attendance.models.Schedule;
import com.koroli.attendance.repos.DisciplineRepository;
import com.koroli.attendance.repos.GroupRepository;
import com.koroli.attendance.repos.ProfessorRepository;
import com.koroli.attendance.repos.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;
    private final ScheduleRepository scheduleRepository;
    private final GroupRepository groupRepository;
    private final ProfessorRepository professorRepository;

    public DisciplineDto createDiscipline(DisciplineForm form) {
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.save(Discipline.builder()
                .name(form.getName())
                .group(groupRepository.findById(form.getGroupId()).orElseThrow(() -> new NotFoundException("Group with this id not found")))
                .professor(professorRepository.findById(form.getProfessorId()).orElseThrow(() -> new NotFoundException("Professor with this id not found")))
                .attendances(new HashSet<>())
                .build()));
    }

    public List<DisciplineDto> hasDiscipline(UUID professorId, LocalDateTime timeNow) {
        return DisciplineMapper.INSTANCE.toDto(
                disciplineRepository.findByTime(
                        professorId,
                        timeNow.getDayOfWeek().name(),
                        new Time(timeNow.toLocalTime().toNanoOfDay())
                ));
    }

    public DisciplineDto getDiscipline(UUID id) {
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.findById(id).orElseThrow(() -> new NotFoundException("Discipline with this id not found")));
    }

    public List<DisciplineDto> getAllDiscipline() {
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.findAll());
    }

    public void deleteDiscipline(UUID id) {
        disciplineRepository.delete(disciplineRepository.findById(id).orElseThrow(() -> new NotFoundException("Discipline with this id not found")));
    }

    public DisciplineDto createSchedule(UUID id, ScheduleForm form) {
        scheduleRepository.save(Schedule.builder()
                .timeStart(form.getTimeStart())
                .timeEnd(form.getTimeEnd())
                .weekday(form.getWeekday())
                .frequency(form.getFrequency())
                .discipline(disciplineRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Discipline with this id not found")))
                .build());
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.findById(id).orElseThrow(() -> new NotFoundException("Discipline with this id not found")));
    }

    public DisciplineDto updateSchedule(UUID id, UUID scheduleId, ScheduleForm form) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NotFoundException("Schedule with this id not found"));

        schedule.setTimeStart(form.getTimeStart());
        schedule.setTimeEnd(form.getTimeEnd());
        schedule.setWeekday(form.getWeekday());
        schedule.setFrequency(form.getFrequency());

        scheduleRepository.save(schedule);
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.findById(id).orElseThrow(() -> new NotFoundException("Discipline with this id not found")));
    }

    public DisciplineDto deleteSchedule(UUID id, UUID scheduleId) {
        scheduleRepository.delete(scheduleRepository.findById(scheduleId).orElseThrow(() -> new NotFoundException("Schedule with this id not found")));
        return DisciplineMapper.INSTANCE.toDto(disciplineRepository.findById(id).orElseThrow(() -> new NotFoundException("Discipline with this id not found")));
    }
}