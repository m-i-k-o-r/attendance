package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.ScheduleDto;
import com.koroli.attendance.models.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleDto toDto(Schedule item);

    List<ScheduleDto> toDto(List<Schedule> items);
}