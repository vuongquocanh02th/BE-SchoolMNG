package com.school_management_api.service.classes;

import com.school_management_api.model.ClassType;
import com.school_management_api.model.DTO.ClassDTO;
import com.school_management_api.model.MyClass;
import com.school_management_api.model.StaffRecord;
import com.school_management_api.repository.IClassRepository;
import com.school_management_api.repository.IClassTypeRepository;
import com.school_management_api.repository.IStaffRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassService implements IClassService {

    private final IClassRepository classRepository;
    private final IClassTypeRepository classTypeRepository;
    private final IStaffRecordRepository staffRecordRepository;

    @Override
    public List<ClassDTO> findAll() {
        return classRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ClassDTO> findById(Long id) {
        return classRepository.findById(id).map(this::toDTO);
    }

    @Override
    public void save(ClassDTO dto) {
        MyClass entity = dto.getId() != null
                ? classRepository.findById(dto.getId()).orElse(new MyClass())
                : new MyClass();

        entity.setClassName(dto.getClassName());
        entity.setSchoolYear(dto.getSchoolYear());
        entity.setMaxStudents(dto.getMaxStudents());

        if (dto.getClassTypeId() != null) {
            ClassType classType = classTypeRepository.findById(dto.getClassTypeId())
                    .orElseThrow(() -> new RuntimeException("Class type not found"));
            entity.setClassType(classType);
        }

        if (dto.getHomeroomTeacherId() != null) {
            StaffRecord teacher = staffRecordRepository.findById(dto.getHomeroomTeacherId())
                    .orElseThrow(() -> new RuntimeException("Homeroom teacher not found"));
            entity.setHomeroomTeacher(teacher);
        }

        classRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        classRepository.deleteById(id);
    }

    private ClassDTO toDTO(MyClass entity) {
        return ClassDTO.builder()
                .id(entity.getId())
                .className(entity.getClassName())
                .schoolYear(entity.getSchoolYear())
                .maxStudents(entity.getMaxStudents())
                .classTypeId(entity.getClassType() != null ? entity.getClassType().getId() : null)
                .homeroomTeacherId(entity.getHomeroomTeacher() != null ? entity.getHomeroomTeacher().getId() : null)
                .build();
    }
}