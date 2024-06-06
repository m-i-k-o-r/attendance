package com.koroli.attendance.controllers;

import com.koroli.attendance.data.dto.GroupDto;
import com.koroli.attendance.data.forms.GroupForm;
import com.koroli.attendance.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    @PostMapping()
    public GroupDto createGroup(@RequestBody GroupForm form) {
        return groupService.createGroup(form);
    }

    /*@PutMapping("/{id}")
    public GroupDto updateGroup(@PathVariable Long id,
                                @RequestBody GroupForm form) {
        return groupService.updateGroup(id, form);
    }*/

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @GetMapping()
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroup();
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
