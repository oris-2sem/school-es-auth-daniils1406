package ru.itis.school.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;

import java.util.List;

@RequestMapping("/parent")
public interface ParentController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    List<ParentResponse> getAll();

    @PostMapping("/create")
    ParentCreateResponse create(@RequestBody ParentRequest parentRequest);

    @PutMapping
    ParentResponse updateById(@RequestBody ParentUpdateRequest newParent);

    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    void deleteById(@RequestBody EntityId entityId);

    @GetMapping("/byId")
    ParentResponse findById(@RequestBody EntityId entityId);
}
