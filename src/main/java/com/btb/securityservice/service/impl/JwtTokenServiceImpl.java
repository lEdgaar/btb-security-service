package com.btb.securityservice.service.impl;

import com.btb.securityservice.dto.GenerateTokenDTO;
import com.btb.securityservice.service.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public String generateToken(GenerateTokenDTO generateTokenDTO) {
        return "Bearer " + Jwts.builder().setSubject(generateTokenDTO.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }
}
