package com.example.clothingstore.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.example.clothingstore.dto.auth.AuthResponseDTO;
import com.example.clothingstore.enums.AccountStatusEnum;
import com.example.clothingstore.enums.RoleEnum;
import com.example.clothingstore.exception.customer.ConflictException;
import com.example.clothingstore.exception.customer.InvalidRefreshTokenException;
import com.example.clothingstore.model.Admin;
import com.example.clothingstore.model.Customer;
import com.example.clothingstore.repository.AdminRepository;
import com.example.clothingstore.repository.CustomerRepository;
import com.example.clothingstore.util.JwtUtil;

import jakarta.transaction.Transactional;

// import ch.qos.logback.core.testUtil.RandomUtil;

@Service
public class AuthService {

    // @Autowired
    // AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    JwtUtil jwtUtil;

    private static long expiration = 1000 * 60 * 60 * 4; // 4h

    final private SecureRandom secureRandom = new SecureRandom();

    // @Autowired
    // private RedisTemplate<String, Object> redisTemplate;

    @Transactional
    public AuthResponseDTO register(String userName, String password) {

        if (customerRepository.existsByUserName(userName)) {
            throw new ConflictException("Tên đăng nhập đã tồn tại");
        }

        Customer customer = new Customer();

        customer.setUserName(userName);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(password);

        customer.setPassword(encodedPassword);

        customer.setStatus(AccountStatusEnum.ACTIVE);

        customerRepository.save(customer);

        return login(userName, password);
    }

    public AuthResponseDTO login(String userName, String password) {
        Customer customer = customerRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Tên đăng nhập không tồn tại"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String code = encoder.encode(password);
        System.out.println(code);

        // if (!employee.getPassword().equals(password)) {
        if (!encoder.matches(password, customer.getPassword())) {
            throw new InvalidRefreshTokenException("Mật khẩu không hợp lệ");
        }

        String accessToken = jwtUtil.generateToken(customer.getUserName(), RoleEnum.ROLE_CUSTOMER.name(),
                expiration);

        byte[] bytes = new byte[50];

        secureRandom.nextBytes(bytes);

        // String refreshToken = Hex.encodeHexString(bytes);

        String refreshToken = new String(Hex.encode(bytes));

        // redisTemplate.opsForValue().set("refreshToken::" + refreshToken,
        // employee.getUsername(), 7, TimeUnit.DAYS);

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setUsername(customer.getUserName());
        authResponseDTO.setRole(RoleEnum.ROLE_CUSTOMER.name());
        authResponseDTO.setAccessToken(accessToken);
        authResponseDTO.setRefreshToken(refreshToken);
        authResponseDTO.setExpiresIn(expiration);
        return authResponseDTO;
    }

    public AuthResponseDTO loginAdmin(String userName, String password) {
        Admin admin = adminRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Tên đăng nhập không tồn tại"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String code = encoder.encode(password);
        System.out.println(code);

        // if (!employee.getPassword().equals(password)) {
        if (!encoder.matches(password, admin.getPassword())) {
            throw new InvalidRefreshTokenException("Mật khẩu không hợp lệ");
        }

        String accessToken = jwtUtil.generateToken(admin.getUserName(), RoleEnum.ROLE_ADMIN.name(),
                expiration);

        byte[] bytes = new byte[50];

        secureRandom.nextBytes(bytes);

        // String refreshToken = Hex.encodeHexString(bytes);

        String refreshToken = new String(Hex.encode(bytes));

        // redisTemplate.opsForValue().set("refreshToken::" + refreshToken,
        // employee.getUsername(), 7, TimeUnit.DAYS);

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setUsername(admin.getUserName());
        authResponseDTO.setRole(RoleEnum.ROLE_ADMIN.name());
        authResponseDTO.setAccessToken(accessToken);
        authResponseDTO.setRefreshToken(refreshToken);
        authResponseDTO.setExpiresIn(expiration);
        return authResponseDTO;
    }

    // public AuthResponseDTO getAccessTokenWithRefreshToken(String refreshToken) {

    // // String userName = (String)
    // redisTemplate.opsForValue().get("refreshToken::" +
    // // refreshToken);

    // if (userName == null) {
    // throw new InvalidRefreshTokenException("refresh Token không hợp lệ");
    // }

    // Employee employee = employeeRepository.findByUsername(userName)
    // .orElseThrow(() -> new RuntimeException("Tên đăng nhập không tồn tại"));

    // String accessToken = jwtUtil.generateToken(employee.getUsername(),
    // employee.getRole().name(),
    // expiration);

    // AuthResponseDTO authResponseDTO = new AuthResponseDTO();
    // authResponseDTO.setUsername(employee.getUsername());
    // authResponseDTO.setRole(employee.getRole().name());
    // authResponseDTO.setAccessToken(accessToken);
    // authResponseDTO.setRefreshToken(refreshToken);
    // authResponseDTO.setExpiresIn(expiration);
    // return authResponseDTO;
    // }

}
