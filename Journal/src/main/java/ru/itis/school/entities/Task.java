package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
//import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.GenericGenerator;
import ru.itis.school.entities.enums.Mark;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String commentary;

    private String description;

    @Enumerated(EnumType.STRING)
    private Mark mark;

    private String type;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson")
    private Lesson lesson;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student")
    private Student student;


}
