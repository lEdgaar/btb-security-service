package com.btb.securityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ResponseTokenDTO {

    private String token;

    private Date expirationDate;

}
