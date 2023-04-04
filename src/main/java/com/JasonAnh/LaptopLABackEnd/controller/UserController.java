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
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @GetMapping("admin/v1/user/get-users")
    public ResponseEntity<?> getAll(@RequestParam final int page,
                                    @RequestParam(required = false) final String phone,
                                    @RequestParam(required = false) final String name,
                                    @RequestParam final boolean deleted) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), userService.getListUser(page, phone, name, deleted),
                    userService.countListUser(page, phone, name, deleted)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("v1/user/get-info")
    public ResponseEntity<?> getInfo(@RequestParam(required = false) Long userId) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), userService.getUserInfo(userId)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @PostMapping("v1/auth/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody final User request) {
        try {
            if(request == null
                    || request.getPhone() == null
                    || request.getPassword() == null
                    || request.getEmail() == null
                    || request.getName() == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
//            return ResponseEntity.badRequest().body(new BaseResponse("Tính năng này đang tạm khoá", null));
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("register_success"), userService.signup(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
}
