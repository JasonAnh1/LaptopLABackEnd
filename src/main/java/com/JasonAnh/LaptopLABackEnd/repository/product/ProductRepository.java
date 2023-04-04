package com.JasonAnh.LaptopLABackEnd.repository.product;


import com.JasonAnh.LaptopLABackEnd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,ProductRepositoryCustom {
    Product findProductById(Long id);
}
