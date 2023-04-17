package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.LessonController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.service.LessonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LessonControllerImpl implements LessonController {

    private final LessonService lessonService;

    @Override
    public List<LessonResponse> getAll() {
        List<LessonResponse> lessonResponses=lessonService.getAll();
        return lessonResponses;
    }

    @Override
    public LessonCreateResponse create(LessonRequest lessonRequest) {
        return lessonService.save(lessonRequest);
    }

    @Override
    public LessonResponse updateById(LessonUpdateRequest newLesson) {
        return lessonService.updateById(newLesson);
    }

    @Override
    public void deleteById(EntityId entityId) {
        lessonService.deleteById(entityId.getId());
    }

    @Override
    public LessonResponse findById(EntityId entityId) {
        return lessonService.findById(entityId.getId());
    }
}
