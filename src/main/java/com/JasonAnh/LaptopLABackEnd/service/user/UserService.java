package com.JasonAnh.LaptopLABackEnd.service.user;

import com.JasonAnh.LaptopLABackEnd.entity.User;


import java.util.List;

public interface UserService {

    /////////////////////User///////////

    User signin(User request) throws Exception;

    User signup(User request) throws Exception;

    User getUserInfo(Long userId) throws Exception;

    User updateProfile(User request) throws Exception;



    /////////////////////Admin///////////
    User adminAddUser(User request) throws Exception;

    User adminSignin(User request) throws Exception;


}
