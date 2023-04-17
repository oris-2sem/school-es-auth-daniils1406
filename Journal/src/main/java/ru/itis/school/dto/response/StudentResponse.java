package ru.itis.school.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.entities.Parent;
import ru.itis.school.entities.SchoolClass;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private SchoolClass schoolClassOfStudent;
    private Parent parent;
    private Set<TaskResponse> taskList;
}
