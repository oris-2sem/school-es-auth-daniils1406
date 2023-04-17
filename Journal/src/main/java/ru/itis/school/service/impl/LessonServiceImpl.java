package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.mapper.LessonMapper;
import ru.itis.school.repository.LessonRepository;
import ru.itis.school.repository.TaskRepository;
import ru.itis.school.repository.TimetableRepository;
import ru.itis.school.service.LessonService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final TimetableRepository timetableRepository;

    private final LessonMapper mapper;
    private final TaskRepository taskRepository;


    @Override
    public List<LessonResponse> getAll() {
        List<Lesson> lessons= lessonRepository.findAll();
        List<LessonResponse> lessonResponses= mapper.fromEntityToResponseList(lessons);
        return lessonResponses;
    }

    @Override
    public LessonCreateResponse save(LessonRequest lessonRequest) {
        Lesson lesson=mapper.fromRequestToEntity(lessonRequest);
        lesson.setTimeTable(timetableRepository.findTimetableById(lessonRequest.getTimeTable()));
        return mapper.fromEntityToCreateResponse(lessonRepository.save(lesson));
    }

    @Override
    public LessonResponse updateById(LessonUpdateRequest newLesson) {
        Lesson lesson=mapper.fromUpdateRequestToEntity(newLesson);
        lesson.setTimeTable(timetableRepository.findTimetableById(newLesson.getTimeTable()));
        mapper.fromEntityToResponse(lessonRepository.save(lesson));
        return findById(newLesson.getId());
    }

    @Override
    public void deleteById(UUID id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public LessonResponse findById(UUID id) {
        return mapper.fromEntityToResponse(lessonRepository.findLessonById(id));
    }
}
