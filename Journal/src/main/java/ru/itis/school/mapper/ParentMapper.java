package ru.itis.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentMapper {

    @Mapping(target = "id", ignore = true)
    Parent fromRequestToEntity(ParentRequest request);

    Parent fromUpdateRequestToEntity(ParentUpdateRequest request);


    ParentResponse fromEntityToResponse(Parent parent);

    ParentCreateResponse fromEntityToCreateResponse(Parent parent);


    List<ParentResponse> fromEntityToResponseList(List<Parent> parent);

    StudentResponse fromEntityToResponseStudent(Student student);

    List<StudentResponse> fromEntityToResponseListStudent(List<Student> request);


}
