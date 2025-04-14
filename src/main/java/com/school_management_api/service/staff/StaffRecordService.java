package com.school_management_api.service.staff;

import com.school_management_api.model.DTO.StaffRecordDTO;
import com.school_management_api.model.StaffRecord;
import com.school_management_api.model.User;
import com.school_management_api.model.type.EUserType;
import com.school_management_api.repository.IStaffRecordRepository;
import com.school_management_api.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffRecordService implements IStaffRecordService {

    private final IStaffRecordRepository staffRepo;
    private final IUserService userService;

    @Override
    public List<StaffRecordDTO> findAll() {
        // Lọc ra các user có quyền GIAO_VIEN
        List<User> teachers = userService.findAll().stream()
                .filter(user -> user.getUserType().equals(EUserType.GIAO_VIEN)) // Giả sử bạn có enum UserType.GIAO_VIEN
                .collect(Collectors.toList());

        // Lọc ra các staff có userId là giáo viên
        return staffRepo.findAll().stream()
                .filter(staff -> teachers.stream()
                        .anyMatch(teacher -> teacher.getId().equals(staff.getUser().getId())))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StaffRecordDTO> findById(Long id) {
        return staffRepo.findById(id).map(this::toDTO);
    }

    @Override
    public void save(StaffRecordDTO dto) {
        StaffRecord entity = dto.getId() != null
                ? staffRepo.findById(dto.getId()).orElse(new StaffRecord())
                : new StaffRecord();

        entity.setAddress(dto.getAddress());
        entity.setSpecialization(dto.getSpecialization());

        if (dto.getUserId() != null) {
            User user = userService.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            entity.setUser(user);
        }

        staffRepo.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        staffRepo.deleteById(id);
    }

    private StaffRecordDTO toDTO(StaffRecord entity) {
        return StaffRecordDTO.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .fullName(entity.getUser().getFullName())
                .address(entity.getAddress())
                .specialization(entity.getSpecialization())
                .build();
    }
}