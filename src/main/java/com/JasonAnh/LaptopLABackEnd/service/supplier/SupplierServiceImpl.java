package com.JasonAnh.LaptopLABackEnd.service.supplier;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.Suppliers;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import com.JasonAnh.LaptopLABackEnd.repository.supplier.SuppliersRepository;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl extends BaseService implements SupplierService {
    @Autowired
    SuppliersRepository suppliersRepository;

    @Override
    public Suppliers createSupplier(Suppliers supplier) throws Exception{
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        return suppliersRepository.save(supplier);
    }

    @Override
    public List<Suppliers> getAllSuppliers() throws Exception {
        return suppliersRepository.findAll();
    }
}
