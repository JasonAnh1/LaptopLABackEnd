package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@Transactional
public class AuthController extends BaseController{
    @Autowired
    private UserService userService;
    @GetMapping ("v1/auth/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody final User request) {
        try {
            if(request == null || request.getPhone() == null || request.getPassword() == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            return ResponseEntity.ok( userService.signin(request));
        } catch (Exception ex) {
            return  ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
}
