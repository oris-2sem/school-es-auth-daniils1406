package ru.itis.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;

import java.util.List;

@RequestMapping("/lesson")
public interface LessonController {
    @GetMapping
    List<LessonResponse> getAll();

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('TEACHER')")
    LessonCreateResponse create(@RequestBody LessonRequest lessonRequest);

    @PutMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    LessonResponse updateById(@RequestBody LessonUpdateRequest newLesson);

    @DeleteMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    LessonResponse findById(@RequestBody EntityId entityId);
}
