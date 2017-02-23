package com.pzeszko.cleansound.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pawel on 2017-01-03.
 */
@Entity
@Table(name = "USERS")
@Data
public class User extends BaseEntity {

    @NotEmpty
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @NotNull
    @Type(type="yes_no")
    @Column(name = "active")
    private Boolean active = Boolean.FALSE;

    public String getUsername() {
        return email.split("@")[0];
    }
}
