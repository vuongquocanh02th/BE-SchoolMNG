package com.school_management_api.repository;

import com.school_management_api.model.StaffRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRecordRepository extends JpaRepository<StaffRecord, Long> {
}
