package com.student.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.sms.entity.StudDet;
import com.student.sms.entity.User;

public interface StudRepository extends JpaRepository<StudDet, Integer> {
    
    List<StudDet> findByBranch(String name);
    User findByEmail(String email);

    // Corrected query with CONCAT for handling wildcards
    @Query(value="SELECT * FROM student_details s WHERE s.name LIKE CONCAT('%', :keyword, '%')", nativeQuery = true)
    List<StudDet> findByKeyword(@Param("keyword") String keyword);

    StudDet findByRegnum(String regNumber);
}
