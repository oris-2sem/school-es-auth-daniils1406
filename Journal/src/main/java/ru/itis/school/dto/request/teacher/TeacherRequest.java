package ru.itis.school.dto.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherRequest {
    private String firstName;

    private String lastName;

    private int age;

    private String merits;

    private String experience;

    private int earn;

    private String email;
    private String password;
}
