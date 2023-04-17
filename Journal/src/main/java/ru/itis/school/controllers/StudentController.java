package ru.itis.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {
    @GetMapping
    List<StudentResponse> getAll();

    @PostMapping("/create")
    StudentCreateResponse create(@RequestBody StudentRequest student);

    @PutMapping
    StudentResponse updateById(@RequestBody StudentUpdateRequest newStudent);

    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    StudentResponse findById(@RequestBody EntityId entityId);
}
