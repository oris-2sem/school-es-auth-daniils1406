package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    Task findTaskById(UUID id);
}
