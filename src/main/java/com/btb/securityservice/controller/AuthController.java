package com.btb.securityservice.controller;

import com.btb.securityservice.dto.GenerateTokenDTO;
import com.btb.securityservice.service.impl.JwtTokenServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenServiceImpl jwtTokenService;


    @Autowired
    public AuthController(JwtTokenServiceImpl jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/authenticate")
    public @ResponseBody String authenticate(@RequestBody GenerateTokenDTO generateTokenDTO) {
        log.trace("GET /auth/login email:");

        log.info("ImportantEvent: EventType: Code: {} Description: It has been successfully logged in");

        return jwtTokenService.generateToken(generateTokenDTO);
    }

}
