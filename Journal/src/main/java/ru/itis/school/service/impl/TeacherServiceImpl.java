package ru.itis.school.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.teacher.TeacherRequest;
import ru.itis.school.dto.request.teacher.TeacherUpdateRequest;
import ru.itis.school.dto.response.TeacherResponse;
import ru.itis.school.entities.Teacher;
import ru.itis.school.entities.enums.Role;
import ru.itis.school.entities.enums.Status;
import ru.itis.school.mapper.TeacherMapper;
import ru.itis.school.repository.TeacherRepository;
import ru.itis.school.service.TeacherService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<TeacherResponse> getAll() {
        List<Teacher> teachers=teacherRepository.findAll();
        List<TeacherResponse> teacherResponseList=mapper.fromEntityListToResponseList(teachers);
        return teacherResponseList;
    }

    @Override
    public TeacherResponse save(TeacherRequest teacherRequest) {
        Teacher teacher=mapper.fromRequestToEntity(teacherRequest);
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher.setRole(Role.TEACHER);
        teacher.setStatus(Status.VERIFIED);
        return mapper.fromEntityToResponse(teacherRepository.save(teacher));
    }

    @Override
    public TeacherResponse updateById(TeacherUpdateRequest newTeacher) {
        Teacher teacher=mapper.fromUpdateRequestToEntity(newTeacher);
        teacher.setRole(Role.TEACHER);
        teacher.setStatus(Status.VERIFIED);
        teacherRepository.save(teacher);
        return mapper.fromEntityToResponse(teacherRepository.findTeacherById(newTeacher.getId()));
    }

    @Override
    public void deleteById(UUID id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse findById(UUID id) {
        return mapper.fromEntityToResponse(teacherRepository.findTeacherById(id));
    }
}
