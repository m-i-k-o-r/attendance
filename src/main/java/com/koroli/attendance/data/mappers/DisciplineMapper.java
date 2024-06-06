package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.DisciplineDto;
import com.koroli.attendance.models.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DisciplineMapper {

    DisciplineMapper INSTANCE = Mappers.getMapper(DisciplineMapper.class);

    DisciplineDto toDto(Discipline item);

    List<DisciplineDto> toDto(List<Discipline> items);
}