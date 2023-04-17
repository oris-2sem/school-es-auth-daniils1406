package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.task.TaskRequest;
import ru.itis.school.dto.request.task.TaskUpdateRequest;
import ru.itis.school.dto.response.TaskResponse;
import ru.itis.school.entities.Task;
import ru.itis.school.mapper.TaskMapper;
import ru.itis.school.repository.LessonRepository;
import ru.itis.school.repository.StudentRepository;
import ru.itis.school.repository.TaskRepository;
import ru.itis.school.service.TaskService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;

    private final TaskMapper mapper;

    @Override
    public List<TaskResponse> getAll() {
        List<Task> tasks=taskRepository.findAll();
        return mapper.fromEntityToResponseList(tasks);
    }

    @Override
    public TaskResponse save(TaskRequest taskRequest) {
        Task task= mapper.fromRequestToEntity(taskRequest);
        task.setStudent(studentRepository.findStudentById(taskRequest.getStudent()));
        task.setLesson(lessonRepository.findLessonById(taskRequest.getLesson()));
        return mapper.fromEntityToResponse(taskRepository.save(task));
    }

    @Override
    public TaskResponse updateById(TaskUpdateRequest newTask) {
        Task task= mapper.fromUpdateRequestToEntity(newTask);
        task.setStudent(studentRepository.findStudentById(newTask.getStudent()));
        task.setLesson(lessonRepository.findLessonById(newTask.getLesson()));
        mapper.fromEntityToResponse(taskRepository.save(task));
        return findById(newTask.getId());
    }

    @Override
    public void deleteById(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponse findById(UUID id) {
        return mapper.fromEntityToResponse(taskRepository.findTaskById(id));
    }
}
