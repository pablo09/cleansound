package com.pzeszko.cleansound.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Pawel on 2017-01-05.
 */
@Data
public class UserDto {
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
