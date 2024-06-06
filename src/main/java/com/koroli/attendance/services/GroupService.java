package com.koroli.attendance.services;

import com.koroli.attendance.data.dto.GroupDto;
import com.koroli.attendance.data.forms.GroupForm;
import com.koroli.attendance.data.mappers.GroupMapper;
import com.koroli.attendance.exceptions.NotFoundException;
import com.koroli.attendance.models.Group;
import com.koroli.attendance.repos.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupDto createGroup(GroupForm form) {
        return GroupMapper.INSTANCE.toDto(groupRepository.save(Group.builder()
                .number(form.getNumber())
                .course(form.getCourse())
                .build()));
    }

    public GroupDto getGroup(Long id) {
        return GroupMapper.INSTANCE.toDto(groupRepository.findById(id).orElseThrow(() -> new NotFoundException("Group with this id not found")));
    }

    public List<GroupDto> getAllGroup() {
        return GroupMapper.INSTANCE.toDto(groupRepository.findAll());
    }

    public void deleteGroup(Long id) {
        groupRepository.delete(groupRepository.findById(id).orElseThrow(() -> new NotFoundException("Group with this id not found")));
    }
}
