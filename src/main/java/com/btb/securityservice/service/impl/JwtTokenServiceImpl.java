package com.btb.securityservice.service.impl;

import com.btb.securityservice.dto.GenerateTokenDTO;
import com.btb.securityservice.dto.ResponseTokenDTO;
import com.btb.securityservice.service.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public ResponseTokenDTO generateToken(GenerateTokenDTO generateTokenDTO) {
        Date dateExpiration = Date
                .from(LocalDateTime
                        .now()
                        .plus(15, ChronoUnit.MINUTES)
                        .atZone(ZoneId.of("Europe/Madrid")).toInstant());

        String token = Jwts
                .builder()
                .setSubject(generateTokenDTO.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return new ResponseTokenDTO(token, dateExpiration);
    }
}
