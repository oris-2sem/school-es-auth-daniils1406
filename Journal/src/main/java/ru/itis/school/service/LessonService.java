package ru.itis.school.service;

import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;

import java.util.List;
import java.util.UUID;

public interface LessonService {
    List<LessonResponse> getAll();

    LessonCreateResponse save(LessonRequest lessonRequest);

    LessonResponse updateById(LessonUpdateRequest newLesson);

    void deleteById(UUID id);

    LessonResponse findById(UUID id);
}
