package com.JasonAnh.LaptopLABackEnd.repository;

import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.response.ContactResponse;
import com.querydsl.core.Tuple;

import java.util.List;

public interface MobileDeviceRepositoryCustom {
    List<MobileDevice> getAllContact();
}
