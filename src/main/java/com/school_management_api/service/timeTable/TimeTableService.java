package com.school_management_api.service.timeTable;

import com.school_management_api.model.DTO.TimeTableDTO;
import com.school_management_api.model.TimeTable;
import com.school_management_api.repository.IClassRepository;
import com.school_management_api.repository.ITimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeTableService implements ITimeTableService {

    private final ITimeTableRepository timeTableRepository;
    private final IClassRepository classRepository;

    @Override
    public List<TimeTableDTO> findAll() {
        return timeTableRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TimeTableDTO> findById(Long id) {
        return timeTableRepository.findById(id)
                .map(this::mapToDTO);
    }

    @Override
    public void save(TimeTableDTO dto) {
        TimeTable entity;
        if (dto.getId() != null) {
            entity = timeTableRepository.findById(dto.getId()).orElse(new TimeTable());
        } else {
            entity = new TimeTable();
        }

        entity.setName(dto.getName());
        entity.setType(dto.getType());

        if (dto.getClassId() != null) {
            classRepository.findById(dto.getClassId()).ifPresent(entity::setMyClass);
        } else {
            entity.setMyClass(null);
        }

        timeTableRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        timeTableRepository.deleteById(id);
    }

    private TimeTableDTO mapToDTO(TimeTable entity) {
        return TimeTableDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .classId(entity.getMyClass() != null ? entity.getMyClass().getId() : null)
                .build();
    }
}
