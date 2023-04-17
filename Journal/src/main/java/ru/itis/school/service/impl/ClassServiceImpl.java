package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.mapper.ClassMapper;
import ru.itis.school.repository.ClassRepository;
import ru.itis.school.repository.TeacherRepository;
import ru.itis.school.service.ClassService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    private final TeacherRepository teacherRepository;

    private final ClassMapper mapper;

    @Override
    public List<ClassResponse> getAll() {
        List<SchoolClass> classes = classRepository.findAll();
        return mapper.fromEntityToResponseList(classes);
    }

    @Override
    public ClassCreateResponse save(ClassRequest classRequest) {
        SchoolClass schoolClass=mapper.fromRequestToEntity(classRequest);
        schoolClass.setLead(teacherRepository.findTeacherById(classRequest.getLead()));
        schoolClass.setDateInsert(Date.valueOf(LocalDate.now()));
        return mapper.fromEntityToCreateResponse(classRepository.save(schoolClass));
    }

    @Override
    public ClassResponse update(ClassUpdateRequest newClass) {
        SchoolClass schoolClass=mapper.fromUpdateRequestToEntity(newClass);
        schoolClass.setLead(teacherRepository.findTeacherById(newClass.getLead()));
        schoolClass.setDateInsert(Date.valueOf(LocalDate.now()));
        mapper.fromEntityToResponse(classRepository.save(schoolClass));
        return findById(newClass.getId());
    }

    @Override
    public void deleteById(UUID id) {
        classRepository.deleteById(id);
    }

    @Override
    public ClassResponse findById(UUID id) {
        return mapper.fromEntityToResponse(classRepository.findSchoolClassById(id));
    }
}
