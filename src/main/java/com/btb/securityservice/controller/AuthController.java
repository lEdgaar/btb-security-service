package com.btb.securityservice.controller;

import com.btb.securityservice.dto.InfoTokenDTO;
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

    @PostMapping("/token")
    public @ResponseBody String authenticate(@RequestBody InfoTokenDTO infoTokenDTO) {
        log.trace("GET /auth/token email: {}", infoTokenDTO.getEmail());

        log.info("ImportantEvent: Generate token for user: {}", infoTokenDTO.getEmail());
        return jwtTokenService.generateToken(infoTokenDTO);
    }

}
