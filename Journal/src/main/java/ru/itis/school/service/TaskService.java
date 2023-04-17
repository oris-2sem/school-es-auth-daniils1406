package ru.itis.school.service;

import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskResponse> getAll();

    TaskResponse save(TaskRequest taskRequest);

    TaskResponse updateById(TaskUpdateRequest newTask);

    void deleteById(UUID id);

    TaskResponse findById(UUID id);
}
