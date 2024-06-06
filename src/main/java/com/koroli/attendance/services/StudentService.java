package com.koroli.attendance.services;

import com.koroli.attendance.data.dto.StudentDto;
import com.koroli.attendance.data.forms.StudentForm;
import com.koroli.attendance.data.mappers.StudentMapper;
import com.koroli.attendance.exceptions.NotFoundException;
import com.koroli.attendance.models.Student;
import com.koroli.attendance.repos.GroupRepository;
import com.koroli.attendance.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentDto createStudent(StudentForm form) {
        return StudentMapper.INSTANCE.toDto(studentRepository.save(Student.builder()
                .idNumberCard(form.getIdNumberCard())
                .fullName(form.getFullName())
                .group(groupRepository.findById(form.getGroupId()).orElseThrow(() -> new NotFoundException("Group with this id not found")))
                .build()));
    }

    public StudentDto getStudent(Long id) {
        return StudentMapper.INSTANCE.toDto(studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student with this id not found")));
    }

    public List<StudentDto> getAllStudent() {
        return StudentMapper.INSTANCE.toDto(studentRepository.findAll());
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student with this id not found")));
    }
}
