package ru.itis.school.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.school.controllers.TimetableController;
import ru.itis.school.dto.EntityId;
import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.service.TimetableService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimeTableControllerImpl implements TimetableController {

    private final TimetableService timetableService;

    @Override
    public List<TimetableResponse> getAll() {
        return timetableService.findAll();
    }

    @Override
    public TimetableCreateResponse create(TimetableRequest timetableRequest) {
        return timetableService.create(timetableRequest);
    }

    @Override
    public TimetableResponse updateById(TimetableUpdateRequest newTimetable) {
        return timetableService.updateById(newTimetable);
    }

    @Override
    public void deleteById(EntityId entityId) {
        timetableService.deleteById(entityId.getId());
    }

    @Override
    public TimetableResponse findById(EntityId entityId) {
        return timetableService.findById(entityId.getId());
    }
}
