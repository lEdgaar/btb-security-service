package com.btb.securityservice.service.impl;

import com.btb.securityservice.dto.InfoTokenDTO;
import com.btb.securityservice.dto.ResponseTokenDTO;
import com.btb.securityservice.service.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Log4j2
@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public ResponseTokenDTO generateToken(InfoTokenDTO infoTokenDTO) {
        log.trace("Generating token for user: {}", infoTokenDTO.getEmail());

        Date dateExpiration = Date
                .from(LocalDateTime
                        .now()
                        .plus(10, ChronoUnit.MINUTES)
                        .atZone(ZoneId.of("Europe/Madrid")).toInstant());

        String token = Jwts
                .builder()
                .setSubject(infoTokenDTO.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        log.trace("Token generated for user: {}", infoTokenDTO.getEmail());
        return new ResponseTokenDTO(token, dateExpiration);
    }

}
