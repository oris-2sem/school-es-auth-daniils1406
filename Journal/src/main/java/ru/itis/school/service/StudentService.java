package ru.itis.school.service;

import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<StudentResponse> findAll();

    StudentCreateResponse create(StudentRequest student);

    StudentResponse updateById(StudentUpdateRequest studentUpdateRequest);

    void deleteById(UUID id);

    StudentResponse findById(UUID id);
}
