package com.koroli.attendance.data.mappers;

import com.koroli.attendance.data.dto.GroupDto;
import com.koroli.attendance.models.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDto toDto(Group item);

    List<GroupDto> toDto(List<Group> items);
}
