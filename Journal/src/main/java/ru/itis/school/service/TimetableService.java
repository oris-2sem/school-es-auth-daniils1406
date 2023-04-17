package ru.itis.school.service;

import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;

import java.util.List;
import java.util.UUID;

public interface TimetableService {
    List<TimetableResponse> findAll();

    TimetableCreateResponse create(TimetableRequest timetableRequest);

    TimetableResponse updateById(TimetableUpdateRequest newTimetable);

    void deleteById(UUID id);

    TimetableResponse findById(UUID id);
}
