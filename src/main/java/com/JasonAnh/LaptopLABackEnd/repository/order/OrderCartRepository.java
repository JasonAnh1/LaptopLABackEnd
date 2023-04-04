package com.JasonAnh.LaptopLABackEnd.repository.order;

import com.JasonAnh.LaptopLABackEnd.entity.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart,Long> {
}
