package ru.itis.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;

import java.util.List;

@RequestMapping("/class")
public interface ClassController {

    @GetMapping
    List<ClassResponse> getAll();

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('TEACHER')")
    ClassCreateResponse create(@RequestBody ClassRequest parentRequest);

    @PutMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    ClassResponse updateById(@RequestBody ClassUpdateRequest newParent);

    @DeleteMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    ClassResponse findById(@RequestBody EntityId entityId);
}
