package ru.itis.school.service;

import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;

import java.util.List;
import java.util.UUID;

public interface ClassService {
    List<ClassResponse> getAll();

    ClassCreateResponse save(ClassRequest classRequest);

    ClassResponse update(ClassUpdateRequest newClass);

    void deleteById(UUID id);

    ClassResponse findById(UUID id);
}
