package ru.itis.school.dto.request.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private UUID schoolClassOfStudent;
    private UUID parent;
    private String email;
}
