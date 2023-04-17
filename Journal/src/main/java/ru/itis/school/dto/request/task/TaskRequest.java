package ru.itis.school.dto.request.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {
    private String commentary;

    private String description;

    private String mark;

    private String type;

    private UUID lesson;

    private UUID student;
}
