package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school.dto.request.lesson.LessonRequest;
import ru.itis.school.dto.request.lesson.LessonUpdateRequest;
import ru.itis.school.dto.response.LessonCreateResponse;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Task;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "taskList",ignore = true)
    @Mapping(target = "timeTable",ignore = true)
    Lesson fromRequestToEntity(LessonRequest lessonRequest);

    @Mapping(target = "taskList",ignore = true)
    @Mapping(target = "timeTable",ignore = true)
    Lesson fromUpdateRequestToEntity(LessonUpdateRequest lessonRequest);


    LessonResponse fromEntityToResponse(Lesson lesson);

    LessonCreateResponse fromEntityToCreateResponse(Lesson lesson);

    List<LessonResponse> fromEntityToResponseList(List<Lesson> lesson);

    TaskResponse fromEntityToResponseTask(Task task);

    List<TaskResponse> fromEntityToResponseListTask(List<Task> task);

}
