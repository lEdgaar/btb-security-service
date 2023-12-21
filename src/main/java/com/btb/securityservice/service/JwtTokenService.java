package com.btb.securityservice.service;

import com.btb.securityservice.dto.InfoTokenDTO;

public interface JwtTokenService {

    String generateToken(InfoTokenDTO infoTokenDTO);

}
