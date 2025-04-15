package com.school_management_api.repository;

import com.school_management_api.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITimeTableRepository extends JpaRepository<TimeTable, Long> {
}
