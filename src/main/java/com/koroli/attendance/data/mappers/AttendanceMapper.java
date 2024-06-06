package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.AttendanceDto;
import com.koroli.attendance.models.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper
public interface AttendanceMapper {

    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    @Mapping(source = "students", target = "students", qualifiedByName = "stringToSet")
    AttendanceDto toDto(Attendance item);

    default Set<Long> toSet(String string) {
        return stringToSet(string);
    }

    List<AttendanceDto> toDto(List<Attendance> items);

    @Named("stringToSet")
    default Set<Long> stringToSet(String s) {
        Set<Long> set = new HashSet<>();
        for (String longString : s.substring(1, s.length() - 1).split(",")) {
            set.add(Long.parseLong(longString.trim()));
        }
        return set;
    }
}

