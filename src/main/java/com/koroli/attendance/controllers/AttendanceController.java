package com.koroli.attendance.controllers;

import com.koroli.attendance.data.dto.AttendanceDto;
import com.koroli.attendance.data.forms.AttendanceForm;
import com.koroli.attendance.services.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping()
    public AttendanceDto createAttendance(@RequestBody AttendanceForm form) {
        return attendanceService.createAttendance(form);
    }

    @PutMapping("/{id}/add-student")
    public void getAttendance(@PathVariable UUID id, @RequestBody Long idNumber) {
        attendanceService.addStudent(id, idNumber);
    }

    @GetMapping("/{id}")
    public AttendanceDto getAttendance(@PathVariable UUID id) {
        return attendanceService.getAttendance(id);
    }

    @GetMapping()
    public List<AttendanceDto> getAllAttendances() {
        return attendanceService.getAllAttendance();
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable UUID id) {
        attendanceService.deleteAttendance(id);
    }
}
