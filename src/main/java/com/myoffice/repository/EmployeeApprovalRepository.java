package com.myoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myoffice.entity.EmployeeApproval;

@Repository
public interface EmployeeApprovalRepository extends JpaRepository<EmployeeApproval, Integer>{

}
