package ru.itis.school.controllers.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.TeacherController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.service.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherControllerImpl implements TeacherController {

    private final TeacherService teacherService;

    @Override
    public List<TeacherResponse> getAll() {
        return teacherService.getAll();
    }

    @Override
    public TeacherResponse create(TeacherRequest teacherRequest) {
        return teacherService.save(teacherRequest);
    }

    @Override
    public TeacherResponse updateById(TeacherUpdateRequest newTeacher) {
        return teacherService.updateById(newTeacher);
    }

    @Override
    public void deleteById(EntityId entityId) {
        teacherService.deleteById(entityId.getId());
    }

    @Override
    public TeacherResponse findById(EntityId entityId) {
        return teacherService.findById(entityId.getId());
    }
}
