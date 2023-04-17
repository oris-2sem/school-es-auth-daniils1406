package ru.itis.school.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.entities.Lesson;
import ru.itis.school.entities.Student;
import ru.itis.school.entities.enums.Mark;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private UUID id;

    private String commentary;

    private String description;

    private Mark mark;

    private String type;

    private Lesson lesson;

    private Student student;
}
