package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.ClassController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.schoolclass.ClassRequest;
import ru.itis.school.dto.request.schoolclass.ClassUpdateRequest;
import ru.itis.school.dto.response.ClassCreateResponse;
import ru.itis.school.dto.response.ClassResponse;
import ru.itis.school.service.ClassService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassControllerImpl implements ClassController {

    private final ClassService classService;

    @Override
    public List<ClassResponse> getAll() {
        return classService.getAll();
    }

    @Override
    public ClassCreateResponse create(ClassRequest classRequest) {
        return classService.save(classRequest);
    }

    @Override
    public ClassResponse updateById(ClassUpdateRequest newClass) {
        return classService.update(newClass);
    }

    @Override
    public void deleteById(EntityId entityId) {
        classService.deleteById(entityId.getId());
    }

    @Override
    public ClassResponse findById(EntityId entityId) {
        return classService.findById(entityId.getId());
    }
}
