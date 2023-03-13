package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
