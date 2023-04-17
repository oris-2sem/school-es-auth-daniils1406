package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Task;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "lesson",ignore = true)
    @Mapping(target = "student",ignore = true)
    Task fromRequestToEntity(TaskRequest request);

    @Mapping(target = "lesson",ignore = true)
    @Mapping(target = "student",ignore = true)
    Task fromUpdateRequestToEntity(TaskUpdateRequest request);

    TaskResponse fromEntityToResponse(Task task);

    List<TaskResponse> fromEntityToResponseList(List<Task> task);

    LessonResponse fromEntityToResponseLesson(Lesson lesson);

    List<LessonResponse> fromEntityToResponseListLesson(List<Lesson> lesson);

}
