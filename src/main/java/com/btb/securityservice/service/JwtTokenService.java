package com.btb.securityservice.service;

import com.btb.securityservice.dto.GenerateTokenDTO;
import com.btb.securityservice.dto.ResponseTokenDTO;

public interface JwtTokenService {

    ResponseTokenDTO generateToken(GenerateTokenDTO generateTokenDTO);

}
