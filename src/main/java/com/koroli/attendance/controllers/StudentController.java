package com.koroli.attendance.controllers;

import com.koroli.attendance.data.dto.StudentDto;
import com.koroli.attendance.data.forms.StudentForm;
import com.koroli.attendance.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public StudentDto createStudent(@RequestBody StudentForm form) {
        return studentService.createStudent(form);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping()
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudent();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}

