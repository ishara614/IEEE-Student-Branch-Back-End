package com.IEEEUWUSB.IEEEStudentBranchBackEnd.repo;

import com.IEEEUWUSB.IEEEStudentBranchBackEnd.entity.Policy;
import com.IEEEUWUSB.IEEEStudentBranchBackEnd.entity.Role;
import com.IEEEUWUSB.IEEEStudentBranchBackEnd.entity.User;
import com.IEEEUWUSB.IEEEStudentBranchBackEnd.entity.UserRoleDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    @Query("SELECT role FROM Role role " +
            "WHERE (:search IS NULL OR role.userRole LIKE CONCAT(:search, '%')) " +
            "AND (:type IS NULL OR role.type LIKE CONCAT(:type, '%')) " +
            "ORDER BY role.roleID DESC")
    Page<Role> findAllRoles(String search, String type,
                            Pageable pageable);

    Optional<Role> findByuserRole(String userRole);


}