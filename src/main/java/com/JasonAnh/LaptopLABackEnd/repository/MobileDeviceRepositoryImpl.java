package com.JasonAnh.LaptopLABackEnd.repository;

import com.JasonAnh.LaptopLABackEnd.entity.MobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.QMobileDevice;
import com.JasonAnh.LaptopLABackEnd.entity.QUser;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.response.ContactResponse;
import com.JasonAnh.LaptopLABackEnd.repository.user.UserRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MobileDeviceRepositoryImpl extends BaseRepository implements MobileDeviceRepositoryCustom{



    @Override
    public List<MobileDevice> getAllContact() {
        QMobileDevice qMobileDevice = QMobileDevice.mobileDevice;

        return query().select(qMobileDevice).from(qMobileDevice).fetch();
    }
}
