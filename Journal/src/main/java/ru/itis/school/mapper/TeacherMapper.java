package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.Timetable;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherResponse fromEntityToResponse(Teacher teacher);

    TimetableResponse fromEntityToResponseTimetable(Timetable timetable);

    List<TimetableResponse> fromEntityToResponseTimetableList(List<Timetable> timetables);

    ClassResponse fromEntityToResponseSchoolClass(SchoolClass schoolClass);


    List<ClassResponse> fromEntityToResponseSchoolClass(List<SchoolClass> schoolClasses);

    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "timetableList",ignore = true)
//    @Mapping(target = "leadId",ignore = true)
    Teacher fromRequestToEntity(TeacherRequest teacherRequest);

//    @Mapping(target = "timetableList",ignore = true)
//    @Mapping(target = "leadId",ignore = true)
    Teacher fromUpdateRequestToEntity(TeacherUpdateRequest teacherRequest);

    List<TeacherResponse> fromEntityListToResponseList(List<Teacher> teachers);
}
