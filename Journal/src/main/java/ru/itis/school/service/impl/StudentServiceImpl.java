package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.student.StudentRequest;
import ru.itis.school.dto.request.student.StudentUpdateRequest;
import ru.itis.school.dto.response.StudentCreateResponse;
import ru.itis.school.dto.response.StudentResponse;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.enums.Role;
import ru.itis.school.entities.enums.Status;
import ru.itis.school.mapper.StudentMapper;
import ru.itis.school.repository.ClassRepository;
import ru.itis.school.repository.ParentRepository;
import ru.itis.school.repository.StudentRepository;
import ru.itis.school.service.StudentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;

    private final ClassRepository classRepository;

    private final StudentMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<StudentResponse> findAll() {
        List<Student> students=studentRepository.findAll();
        return mapper.fromEntityToResponseList(students);
    }

    @Override
    public StudentCreateResponse create(StudentRequest student) {
        Student studentEntity=mapper.fromRequestToEntity(student);
        studentEntity.setParent(parentRepository.findParentById(student.getParent()));
        studentEntity.setSchoolClassOfStudent(classRepository.findSchoolClassById(student.getSchoolClassOfStudent()));
        studentEntity.setPassword(passwordEncoder.encode(studentEntity.getPassword()));
        studentEntity.setStatus(Status.VERIFIED);
        studentEntity.setRole(Role.STUDENT);
        return mapper.fromEntityToCreateResponse(studentRepository.save(studentEntity));
    }

    @Override
    public StudentResponse updateById(StudentUpdateRequest request) {
        Student studentEntity=mapper.fromUpdateRequestToEntity(request);
        studentEntity.setParent(parentRepository.findParentById(request.getParent()));
        studentEntity.setSchoolClassOfStudent(classRepository.findSchoolClassById(request.getSchoolClassOfStudent()));
        studentEntity.setStatus(Status.VERIFIED);
        studentEntity.setRole(Role.STUDENT);
        mapper.fromEntityToResponse(studentRepository.save(studentEntity));
        return findById(request.getId());
    }

    @Override
    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse findById(UUID id) {
        return mapper.fromEntityToResponse(studentRepository.findStudentById(id));
    }
}
