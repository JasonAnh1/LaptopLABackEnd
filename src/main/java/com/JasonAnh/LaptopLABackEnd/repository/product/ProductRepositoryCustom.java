package com.JasonAnh.LaptopLABackEnd.repository.product;

import com.JasonAnh.LaptopLABackEnd.entity.Product;


import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> getProducts(int page, String name,Long categoryId);
}
