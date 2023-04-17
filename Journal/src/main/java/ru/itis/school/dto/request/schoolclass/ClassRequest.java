package ru.itis.school.dto.request.schoolclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRequest {
    private UUID lead;
    private String letter;
    private int studentsNumber;
}
