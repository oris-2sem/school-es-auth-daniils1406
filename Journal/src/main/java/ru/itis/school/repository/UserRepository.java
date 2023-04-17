package ru.itis.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.school.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);
}
