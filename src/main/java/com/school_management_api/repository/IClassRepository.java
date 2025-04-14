package com.school_management_api.repository;

import com.school_management_api.model.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<MyClass, Long> {
}
