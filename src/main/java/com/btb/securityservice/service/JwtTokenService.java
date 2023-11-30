package com.btb.securityservice.service;

import com.btb.securityservice.dto.GenerateTokenDTO;

public interface JwtTokenService {

    String generateToken(GenerateTokenDTO generateTokenDTO);

}
