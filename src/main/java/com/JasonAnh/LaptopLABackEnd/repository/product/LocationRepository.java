package com.JasonAnh.LaptopLABackEnd.repository.product;

import com.JasonAnh.LaptopLABackEnd.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
