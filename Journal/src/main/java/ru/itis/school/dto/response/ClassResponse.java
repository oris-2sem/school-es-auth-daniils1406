package ru.itis.school.dto.response;


import lombok.*;
import ru.itis.school.entities.Teacher;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassResponse {
    private UUID id;
    private Teacher lead;
    private String letter;
    private int studentsNumber;
    private List<StudentResponse> studentList;
    private List<TimetableResponse> timetableList;
}