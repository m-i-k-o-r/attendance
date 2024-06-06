package com.koroli.attendance.services;

import com.koroli.attendance.data.dto.AttendanceDto;
import com.koroli.attendance.data.forms.AttendanceForm;
import com.koroli.attendance.data.mappers.AttendanceMapper;
import com.koroli.attendance.exceptions.NotFoundException;
import com.koroli.attendance.models.Attendance;
import com.koroli.attendance.models.Student;
import com.koroli.attendance.repos.AttendanceRepository;
import com.koroli.attendance.repos.DisciplineRepository;
import com.koroli.attendance.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final DisciplineRepository disciplineRepository;

    public AttendanceDto createAttendance(AttendanceForm form) {
        return AttendanceMapper.INSTANCE.toDto(attendanceRepository.save(Attendance.builder()
                .dateTime(LocalDateTime.now())
                .isComplete(false)
                .discipline(disciplineRepository.findById(form.getDisciplineId()).orElseThrow(() -> new NotFoundException("Discipline with this id not found")))
                .build()));
    }

    public void addStudent(UUID id, Long idNumber) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new NotFoundException("Attendance with this id not found"));
        Student student = studentRepository.findById(idNumber).orElseThrow(() -> new NotFoundException("Student with this id not found"));

        // принадлежит ли студент к этой группе
        if (!attendance.getDiscipline().getGroup().getStudents().contains(student)) {
            throw new NotFoundException(
                    String.format("Student is not from %s courses %s group",
                            attendance.getDiscipline().getGroup().getCourse(),
                            attendance.getDiscipline().getGroup().getNumber()
                    ));
        }

        // преобразование списка отмеченных студентов в формате string в set
        Set<Long> listStudents = AttendanceMapper.INSTANCE.toSet(attendance.getStudents());

        // отмечен ли студент
        if (listStudents.contains(idNumber)) {
            throw new NotFoundException("Student has already been marked");
        }

        listStudents.add(idNumber);
    }

    public AttendanceDto closeAttendance(UUID id) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(() -> new NotFoundException("Attendance with this id not found"));
        attendance.setComplete(false);
        return AttendanceMapper.INSTANCE.toDto(attendanceRepository.save(attendance));
    }

    public AttendanceDto getAttendance(UUID id) {
        return AttendanceMapper.INSTANCE.toDto(attendanceRepository.findById(id).orElseThrow(() -> new NotFoundException("Attendance with this id not found")));
    }

    public List<AttendanceDto> getAllAttendance() {
        return AttendanceMapper.INSTANCE.toDto(attendanceRepository.findAll());
    }

    public void deleteAttendance(UUID id) {
        attendanceRepository.delete(attendanceRepository.findById(id).orElseThrow(() -> new NotFoundException("Attendance with this id not found")));
    }
}
