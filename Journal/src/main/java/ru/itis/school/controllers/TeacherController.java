package ru.itis.school.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;

import java.util.List;

@RequestMapping("/teacher")
public interface TeacherController {
    @GetMapping
    List<TeacherResponse> getAll();

    @PostMapping("/create")
    TeacherResponse create(@RequestBody TeacherRequest teacherRequest);

    @PutMapping
    TeacherResponse updateById(@RequestBody TeacherUpdateRequest newTeacher);

    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    TeacherResponse findById(@RequestBody EntityId entityId);
}
