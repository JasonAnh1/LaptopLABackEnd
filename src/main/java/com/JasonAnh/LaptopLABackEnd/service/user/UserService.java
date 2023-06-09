package com.JasonAnh.LaptopLABackEnd.service.user;

import com.JasonAnh.LaptopLABackEnd.entity.User;


import java.util.List;

public interface UserService {

    /////////////////////User///////////
    void test() throws Exception;
    User signin(User request) throws Exception;

    User signup(User request) throws Exception;

    User getUserInfo(Long userId) throws Exception;

    User updateProfile(User request) throws Exception;



    /////////////////////Admin///////////
    User adminAddUser(User request) throws Exception;

    User adminSignin(User request) throws Exception;
    List<User> getListUser2()throws Exception;
    List<User> getListUser(int page, String phone, String name, boolean deleted)throws Exception;
    Long countListUser(int page, String phone, String name, boolean deleted)throws Exception;

}
