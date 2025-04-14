package com.school_management_api.controller;

import com.school_management_api.model.DTO.ClassDTO;
import com.school_management_api.service.classes.IClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClassController {

    private final IClassService classService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(classService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return classService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClassDTO dto) {
        classService.save(dto);
        return ResponseEntity.ok("Lưu lớp học thành công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        classService.deleteById(id);
        return ResponseEntity.ok("Xóa lớp học thành công");
    }
}
