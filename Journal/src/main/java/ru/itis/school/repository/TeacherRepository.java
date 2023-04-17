package ru.itis.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Teacher;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    Teacher findTeacherById(UUID id);
}
