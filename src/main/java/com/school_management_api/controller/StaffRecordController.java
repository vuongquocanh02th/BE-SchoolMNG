package com.school_management_api.controller;

import com.school_management_api.model.DTO.StaffRecordDTO;
import com.school_management_api.service.staff.IStaffRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff-records")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StaffRecordController {

    private final IStaffRecordService staffService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(staffService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return staffService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StaffRecordDTO dto) {
        staffService.save(dto);
        return ResponseEntity.ok("Lưu giáo viên thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        staffService.deleteById(id);
        return ResponseEntity.ok("Xóa giáo viên thành công");
    }
}

