package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "taskList",ignore = true)
    @Mapping(target = "schoolClassOfStudent",ignore = true)
    @Mapping(target = "parent",ignore = true)
    Student fromRequestToEntity(StudentRequest request);


    @Mapping(target = "taskList",ignore = true)
    @Mapping(target = "schoolClassOfStudent",ignore = true)
    @Mapping(target = "parent",ignore = true)
    Student fromUpdateRequestToEntity(StudentUpdateRequest request);



    StudentResponse fromEntityToResponse(Student student);

    StudentCreateResponse fromEntityToCreateResponse(Student student);

    List<StudentResponse> fromEntityToResponseList(List<Student> request);

    TaskResponse fromEntityToResponseTask(Task task);

    List<TaskResponse> fromEntityToResponseListTask(List<Task> task);



}
