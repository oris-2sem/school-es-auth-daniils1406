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
public class ClassUpdateRequest {
    private UUID id;
    private UUID lead;
    private String letter;
    private int studentsNumber;
}
