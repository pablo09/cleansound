package com.pzeszko.cleansound.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Pawel on 2017-01-03.
 */
@Data
public class LoginFormDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
