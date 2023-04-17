package ru.itis.school.service;

import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    List<ParentResponse> getAll();

    ParentCreateResponse save(ParentRequest parentRequest);

    ParentResponse updateById(ParentUpdateRequest newParent);

    void deleteById(UUID id);

    ParentResponse findById(UUID id);
}
