package com.JasonAnh.LaptopLABackEnd.repository.user;

import com.JasonAnh.LaptopLABackEnd.entity.User;


import java.util.List;

public interface UserRepositoryCustom {
    List<User> getListUser(int page,String phone,String name,boolean deleted);
    List<User> getListUser2();
    Long countListUser(String phone,String name,boolean deleted);
}
