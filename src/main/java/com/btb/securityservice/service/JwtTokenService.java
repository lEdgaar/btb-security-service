package com.btb.securityservice.service;

import com.btb.securityservice.dto.InfoTokenDTO;
import com.btb.securityservice.dto.ResponseTokenDTO;

public interface JwtTokenService {

    ResponseTokenDTO generateToken(InfoTokenDTO infoTokenDTO);

}
