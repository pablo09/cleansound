package com.pzeszko.cleansound.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2017-01-05.
 */
@Data
public class UserDto {
    @NotEmpty
    private String email;
    @NotNull
    private boolean active;
}
