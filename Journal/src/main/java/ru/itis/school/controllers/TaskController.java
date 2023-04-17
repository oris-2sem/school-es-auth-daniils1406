package ru.itis.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.TaskResponse;

import java.util.List;

@RequestMapping("/task")
public interface TaskController {
    @GetMapping
    List<TaskResponse> getAll();

    @PostMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    TaskResponse create(@RequestBody TaskRequest taskRequest);

    @PutMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    TaskResponse updateById(@RequestBody TaskUpdateRequest newTask);

    @DeleteMapping
    @PreAuthorize("hasAuthority('TEACHER')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    TaskResponse findById(@RequestBody EntityId entityId);
}
