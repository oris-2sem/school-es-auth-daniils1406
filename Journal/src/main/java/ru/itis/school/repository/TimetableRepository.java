package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Timetable;

import java.util.UUID;

public interface TimetableRepository extends JpaRepository<Timetable, UUID> {
    Timetable findTimetableById(UUID id);
}
