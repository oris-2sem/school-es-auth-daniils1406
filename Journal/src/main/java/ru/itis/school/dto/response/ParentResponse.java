package ru.itis.school.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private List<StudentResponse> children;
}
