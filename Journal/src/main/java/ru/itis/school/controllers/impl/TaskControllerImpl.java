package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.TaskController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @Override
    public List<TaskResponse> getAll() {
        return taskService.getAll();
    }

    @Override
    public TaskResponse create(TaskRequest taskRequest) {
        return taskService.save(taskRequest);
    }

    @Override
    public TaskResponse updateById(TaskUpdateRequest newTask) {
        return taskService.updateById(newTask);
    }

    @Override
    public void deleteById(EntityId entityId) {
        taskService.deleteById(entityId.getId());
    }

    @Override
    public TaskResponse findById(EntityId entityId) {
        return taskService.findById(entityId.getId());
    }
}
