package com.JasonAnh.LaptopLABackEnd.repository.user;

import com.JasonAnh.LaptopLABackEnd.entity.User;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhone(String phone);

    User findUserById(long id);



}
