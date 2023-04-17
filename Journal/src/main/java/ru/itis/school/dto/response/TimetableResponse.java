package ru.itis.school.dto.response;


import lombok.*;
import ru.itis.school.entities.SchoolClass;
import ru.itis.school.entities.Teacher;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimetableResponse {
    private UUID id;
    private Date dateTime;
    private int room;
    private SchoolClass schoolClassOfTimetable;
    private Teacher teacher;
    private List<LessonResponse> timetable;
}
