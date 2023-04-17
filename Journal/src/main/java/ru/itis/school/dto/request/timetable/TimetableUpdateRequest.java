package ru.itis.school.dto.request.timetable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimetableUpdateRequest {
    private UUID id;
    private Date dateTime;
    private int room;
    private UUID schoolClassOfTimetable;
    private UUID teacher;
}
