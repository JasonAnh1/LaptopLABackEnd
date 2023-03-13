package com.JasonAnh.LaptopLABackEnd.service.user;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import com.JasonAnh.LaptopLABackEnd.repository.user.RoleRepository;
import com.JasonAnh.LaptopLABackEnd.security.CustomUserDetailsService;
import com.JasonAnh.LaptopLABackEnd.security.JwtTokenProvider;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Service
class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    /////////////////////User///////////

    public User signin(User request) throws Exception {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPhone(), request.getPassword()));
        } catch (Exception e) {
            throw new Exception(Translator.toLocale("login_fail"));
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByPhone(request.getPhone()).orElseThrow(() -> new UsernameNotFoundException(String.format(Translator.toLocale("user_not_found_with_phone"), request.getPhone())));
        if (user.getDeleted()) {
            throw new Exception("Tài khoản đã bị xoá");
        }
        String jwt = tokenProvider.generateToken(authentication);
        user.setAccessToken(jwt);
        return user;
    }

    @Override
    public User signup(User request) throws Exception {
        return null;
    }

    @Override
    public User getUserInfo(Long userId) throws Exception {
        return null;
    }

    @Override
    public User updateProfile(User request) throws Exception {
        return null;
    }

    @Override
    public User adminAddUser(User request) throws Exception {
        return null;
    }

    @Override
    public User adminSignin(User request) throws Exception {
        return null;
    }

    @Override
    public List<User> getListUser(int page, String phone, String name, boolean deleted) throws Exception {
        User user = getUser();
        if (user ==null || user.getRoles().get(0).getName() == RoleName.ROLE_USER ) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        return userRepository.getListUser(page, phone, name,deleted);
    }

    @Override
    public Long countListUser(int page, String phone, String name, boolean deleted) throws Exception {
        User user = getUser();
        if (user ==null || user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        return userRepository.countListUser(phone, name,deleted);
    }
}
