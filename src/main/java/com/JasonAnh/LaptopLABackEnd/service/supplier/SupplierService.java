package com.JasonAnh.LaptopLABackEnd.service.supplier;

import com.JasonAnh.LaptopLABackEnd.entity.Suppliers;

import java.util.List;
import java.util.function.Supplier;

public interface SupplierService {
    Suppliers createSupplier(Suppliers supplier) throws Exception;
    List<Suppliers> getAllSuppliers() throws Exception;
}
