package com.school_management_api.controller;

import com.school_management_api.model.DTO.ClassTypeDTO;
import com.school_management_api.service.classType.IClassTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class-types")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClassTypeController {

    private final IClassTypeService classTypeService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(classTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return classTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClassTypeDTO dto) {
        classTypeService.save(dto);
        return ResponseEntity.ok("Lưu khối thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        classTypeService.deleteById(id);
        return ResponseEntity.ok("Xóa khối thành công");
    }
}
