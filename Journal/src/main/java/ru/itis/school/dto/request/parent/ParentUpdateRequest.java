package ru.itis.school.dto.request.parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentUpdateRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
}
