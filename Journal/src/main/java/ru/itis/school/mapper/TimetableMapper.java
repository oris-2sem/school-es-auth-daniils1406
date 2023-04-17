package ru.itis.school.mapper;

import org.mapstruct.*;
import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.LessonResponse;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.Timetable;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimetableMapper {
    
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "lessonList",ignore = true)
    @Mapping(target = "teacher",ignore = true)
    @Mapping(target = "schoolClassOfTimetable",ignore = true)
    Timetable fromRequestToEntity(TimetableRequest request);

    @Mapping(target = "lessonList",ignore = true)
    @Mapping(target = "teacher",ignore = true)
    @Mapping(target = "schoolClassOfTimetable",ignore = true)
    Timetable fromUpdateRequestToEntity(TimetableUpdateRequest request);

    TimetableResponse fromEntityToResponse(Timetable timetable);

    TimetableCreateResponse fromEntityToCreateResponse(Timetable timetable);


    List<TimetableResponse> fromEntityToResponseList(List<Timetable> timetable);

    LessonResponse fromEntityToResponseLesson(Lesson lesson);

    List<LessonResponse> fromEntityToResponseListLesson(List<Lesson> lesson);

    TeacherResponse fromEntityToResponse(Teacher teacher);



}
