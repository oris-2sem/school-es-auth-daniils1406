package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.Parent;

import java.util.UUID;

public interface ParentRepository extends JpaRepository<Parent, UUID> {
    Parent findParentById(UUID id);
}
