package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.ProfessorDto;
import com.koroli.attendance.models.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfessorMapper {

    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorDto toDto(Professor item);

    List<ProfessorDto> toDto(List<Professor> items);
}
