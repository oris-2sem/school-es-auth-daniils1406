package ru.itis.school.service;


import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    List<TeacherResponse> getAll();

    TeacherResponse save(TeacherRequest teacherRequest);

    TeacherResponse updateById(TeacherUpdateRequest newTeacher);

    void deleteById(UUID id);

    TeacherResponse findById(UUID id);
}
