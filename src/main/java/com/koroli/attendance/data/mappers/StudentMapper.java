package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.StudentDto;
import com.koroli.attendance.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student item);

    List<StudentDto> toDto(List<Student> items);
}
