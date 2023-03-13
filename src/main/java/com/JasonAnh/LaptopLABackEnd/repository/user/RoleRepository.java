package com.JasonAnh.LaptopLABackEnd.repository.user;

import com.JasonAnh.LaptopLABackEnd.entity.Role;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByTitle(String roleName);

    Optional<Role> findByName(RoleName roleName);
}
