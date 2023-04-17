package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.SchoolClass;

import java.util.UUID;

public interface ClassRepository extends JpaRepository<SchoolClass, UUID> {
    SchoolClass findSchoolClassById(UUID id);
}
