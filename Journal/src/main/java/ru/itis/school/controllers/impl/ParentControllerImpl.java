package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.ParentController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.service.ParentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParentControllerImpl implements ParentController {

    private final ParentService parentService;

    @Override
    public List<ParentResponse> getAll() {
        return parentService.getAll();
    }

    @Override
    public ParentCreateResponse create(ParentRequest parentRequest) {
        return parentService.save(parentRequest);
    }

    @Override
    public ParentResponse updateById(ParentUpdateRequest newParent) {
        return parentService.updateById(newParent);
    }

    @Override
    public void deleteById(EntityId entityId) {
        parentService.deleteById(entityId.getId());
    }

    @Override
    public ParentResponse findById(EntityId entityId) {
        return parentService.findById(entityId.getId());
    }
}
