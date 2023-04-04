package com.JasonAnh.LaptopLABackEnd.repository.supplier;

import com.JasonAnh.LaptopLABackEnd.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers,Long> {
}
