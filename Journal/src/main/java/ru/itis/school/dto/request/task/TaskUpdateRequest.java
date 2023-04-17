package ru.itis.school.dto.request.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.entities.enums.Mark;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUpdateRequest {
    private UUID id;

    private String commentary;

    private String description;

    private Mark mark;

    private String type;

    private UUID lesson;

    private UUID student;
}
