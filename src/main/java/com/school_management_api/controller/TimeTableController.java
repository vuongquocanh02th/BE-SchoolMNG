package com.school_management_api.controller;

import com.school_management_api.model.DTO.TimeTableDTO;
import com.school_management_api.service.timeTable.ITimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TimeTableController {

    private final ITimeTableService timeTableService;

    @GetMapping
    public ResponseEntity<List<TimeTableDTO>> getAll() {
        return ResponseEntity.ok(timeTableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeTableDTO> getById(@PathVariable Long id) {
        return timeTableService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TimeTableDTO dto) {
        dto.setId(null);
        timeTableService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TimeTableDTO dto) {
        dto.setId(id);
        timeTableService.save(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        timeTableService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
