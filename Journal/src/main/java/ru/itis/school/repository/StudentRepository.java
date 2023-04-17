package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Student;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findStudentById(UUID id);
}
