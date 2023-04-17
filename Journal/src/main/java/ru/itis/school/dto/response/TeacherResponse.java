package ru.itis.school.dto.response;


import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
    private UUID id;

    private String firstName;

    private String lastName;

    private int age;

    private String merits;

    private String experience;

    private int earn;

    private List<TimetableResponse> timeTableList;

    private List<ClassResponse> schoolClassList;
}
