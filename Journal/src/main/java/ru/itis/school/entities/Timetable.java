package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
//import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Timetable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private Date dateTime;

    private int room;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classOfTimetable")
    private SchoolClass schoolClassOfTimetable;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @JsonManagedReference
    @OneToMany(mappedBy = "timeTable",fetch = FetchType.EAGER)
    private Set<Lesson> lessonList;

    @PreRemove
    private void preRemove(){
        for(Lesson lesson:lessonList){
            lesson.setTimeTable(null);
        }
    }
}
