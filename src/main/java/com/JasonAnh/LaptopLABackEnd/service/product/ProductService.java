package com.JasonAnh.LaptopLABackEnd.service.product;

import com.JasonAnh.LaptopLABackEnd.entity.Location;
import com.JasonAnh.LaptopLABackEnd.entity.Product;
import com.JasonAnh.LaptopLABackEnd.entity.ProductCategory;

import java.util.List;

public interface ProductService  {
  Product addProduct(Product product) throws Exception;
  ProductCategory  addProductCategory(ProductCategory productCategory)throws Exception ;
  List<ProductCategory> getAllProductCategory()throws Exception ;
  List<Product> getListProduct(int page, String name,Long categoryId) throws Exception;
  Product getProductById(Long id) throws Exception;
  void deleteProduct(Long id  ) throws Exception;
  List<Location> getLocation() throws Exception;
  Product updateProduct(Product product) throws Exception;
}
