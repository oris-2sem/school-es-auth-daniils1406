package ru.itis.school.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.SchoolClass;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private SchoolClass schoolClassOfStudent;
    private Parent parent;
}