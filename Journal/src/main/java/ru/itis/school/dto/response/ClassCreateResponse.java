package ru.itis.school.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.school.entities.Teacher;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassCreateResponse {
    private UUID id;
    private Teacher lead;
    private String letter;
    private int studentsNumber;
}
