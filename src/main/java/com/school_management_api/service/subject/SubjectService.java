package com.school_management_api.service.subject;

import com.school_management_api.model.DTO.SubjectDTO;
import com.school_management_api.model.Subject;
import com.school_management_api.repository.ISubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {

    private final ISubjectRepository subjectRepository;

    private SubjectDTO convertToDTO(Subject subject) {
        return SubjectDTO.builder()
                .id(subject.getId())
                .name(subject.getName())
                .shortName(subject.getShortName())
                .creditHours(subject.getCreditHours())
                .coefficient(subject.getCoefficient())
                .build();
    }

    private Subject convertToEntity(SubjectDTO dto) {
        return Subject.builder()
                .id(dto.getId())
                .name(dto.getName())
                .shortName(dto.getShortName())
                .creditHours(dto.getCreditHours())
                .coefficient(dto.getCoefficient() != null ? dto.getCoefficient() : 1)
                .build();
    }

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SubjectDTO> findById(Long id) {
        return subjectRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public void save(SubjectDTO subjectDTO) {
        Subject subject = convertToEntity(subjectDTO);
        subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }
}
