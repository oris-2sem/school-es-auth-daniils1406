package ru.itis.school.dto.request.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRequest {
    private String theme;
    private String subject;
    private UUID timeTable;
}
