package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.StudentController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    public List<StudentResponse> getAll() {
        return studentService.findAll();
    }

    @Override
    public StudentCreateResponse create(StudentRequest student) {
        return studentService.create(student);
    }

    @Override
    public StudentResponse updateById(StudentUpdateRequest newStudent) {
        return studentService.updateById(newStudent);
    }

    @Override
    public void deleteById(EntityId entityId) {
        studentService.deleteById(entityId.getId());
    }

    @Override
    public StudentResponse findById(EntityId entityId) {
        return studentService.findById(entityId.getId());
    }
}
