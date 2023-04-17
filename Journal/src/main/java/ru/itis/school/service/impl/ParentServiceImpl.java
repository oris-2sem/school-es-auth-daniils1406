package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.parent.ParentRequest;
import ru.itis.school.dto.request.parent.ParentUpdateRequest;
import ru.itis.school.dto.response.ParentCreateResponse;
import ru.itis.school.dto.response.ParentResponse;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.enums.Role;
import ru.itis.school.entities.enums.Status;
import ru.itis.school.mapper.ParentMapper;
import ru.itis.school.repository.ParentRepository;
import ru.itis.school.service.ParentService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    private final ParentMapper mapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<ParentResponse> getAll() {
        List<Parent> parents=parentRepository.findAll();
        return mapper.fromEntityToResponseList(parents);
    }

    @Override
    public ParentCreateResponse save(ParentRequest parentRequest) {
        parentRequest.setPassword(passwordEncoder.encode(parentRequest.getPassword()));
        Parent parent=mapper.fromRequestToEntity(parentRequest);
        parent.setStatus(Status.VERIFIED);
        parent.setRole(Role.PARENT);
        return mapper.fromEntityToCreateResponse(parentRepository.save(parent));
    }

    @Override
    public ParentResponse updateById(ParentUpdateRequest newParent) {
        Parent parent=mapper.fromUpdateRequestToEntity(newParent);
        parent.setStatus(Status.VERIFIED);
        parent.setRole(Role.PARENT);
        mapper.fromEntityToResponse(parentRepository.save(parent));
        return findById(newParent.getId());
    }

    @Override
    public void deleteById(UUID id) {
        parentRepository.deleteById(id);
    }

    @Override
    public ParentResponse findById(UUID id) {
        return mapper.fromEntityToResponse(parentRepository.findParentById(id));
    }
}
