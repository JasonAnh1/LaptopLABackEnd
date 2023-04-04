package com.JasonAnh.LaptopLABackEnd.repository.product;

import com.JasonAnh.LaptopLABackEnd.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    boolean existsByTitle(String title);
}
