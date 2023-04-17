package ru.itis.school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.school.dto.request.timetable.TimetableRequest;
import ru.itis.school.dto.request.timetable.TimetableUpdateRequest;
import ru.itis.school.dto.response.TimetableCreateResponse;
import ru.itis.school.dto.response.TimetableResponse;
import ru.itis.school.entities.Timetable;
import ru.itis.school.mapper.TimetableMapper;
import ru.itis.school.repository.ClassRepository;
import ru.itis.school.repository.TeacherRepository;
import ru.itis.school.repository.TimetableRepository;
import ru.itis.school.service.TimetableService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimetableServiceImpl implements TimetableService {

    private final TimetableRepository timetableRepository;
    private final TeacherRepository teacherRepository;
    private final ClassRepository classRepository;

    private final TimetableMapper mapper;

    @Override
    public List<TimetableResponse> findAll() {
        List<Timetable> timetables=timetableRepository.findAll();
        return mapper.fromEntityToResponseList(timetables);
    }

    @Override
    public TimetableCreateResponse create(TimetableRequest timetableRequest) {
        Timetable timetable=mapper.fromRequestToEntity(timetableRequest);
        timetable.setTeacher(teacherRepository.findTeacherById(timetableRequest.getTeacher()));
        timetable.setSchoolClassOfTimetable(classRepository.findSchoolClassById(timetableRequest.getSchoolClassOfTimetable()));
        return mapper.fromEntityToCreateResponse(timetableRepository.save(timetable));
    }

    @Override
    public TimetableResponse updateById(TimetableUpdateRequest newTimetable) {
        Timetable timetable=mapper.fromUpdateRequestToEntity(newTimetable);
        timetable.setTeacher(teacherRepository.findTeacherById(newTimetable.getTeacher()));
        timetable.setSchoolClassOfTimetable(classRepository.findSchoolClassById(newTimetable.getSchoolClassOfTimetable()));
        mapper.fromEntityToResponse(timetableRepository.save(timetable));
        return findById(newTimetable.getId());
    }

    @Override
    public void deleteById(UUID id) {
        timetableRepository.deleteById(id);
    }

    @Override
    public TimetableResponse findById(UUID id) {
        return mapper.fromEntityToResponse(timetableRepository.findTimetableById(id));
    }
}
