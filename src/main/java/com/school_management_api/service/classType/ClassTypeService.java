package com.school_management_api.service.classType;

import com.school_management_api.model.ClassType;
import com.school_management_api.model.DTO.ClassTypeDTO;
import com.school_management_api.repository.IClassTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassTypeService implements IClassTypeService {

    private final IClassTypeRepository classTypeRepo;

    @Override
    public List<ClassTypeDTO> findAll() {
        return classTypeRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ClassTypeDTO> findById(Long id) {
        return classTypeRepo.findById(id).map(this::toDTO);
    }

    @Override
    public void save(ClassTypeDTO dto) {
        ClassType entity = dto.getId() != null
                ? classTypeRepo.findById(dto.getId()).orElse(new ClassType())
                : new ClassType();

        entity.setName(dto.getName());
        classTypeRepo.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        classTypeRepo.deleteById(id);
    }

    private ClassTypeDTO toDTO(ClassType entity) {
        return ClassTypeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
