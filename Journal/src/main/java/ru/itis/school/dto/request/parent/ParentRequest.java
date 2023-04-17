package ru.itis.school.dto.request.parent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentRequest {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
}
