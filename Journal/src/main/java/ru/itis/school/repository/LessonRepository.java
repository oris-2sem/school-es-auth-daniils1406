package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Lesson;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {

    Lesson findLessonById(UUID id);
}
