package com.pzeszko.cleansound.config.security;

import com.pzeszko.cleansound.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.annotation.PostConstruct;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String[] PERMITED_URLS = {"/" ,"/css/**", "/js/**", "/img/**"};

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    public void testNormal() {
        System.out.println("WTF");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .csrfTokenRepository(csrfTokenRepository())
                    .and()
                .authorizeRequests()
                    .antMatchers(PERMITED_URLS).permitAll()
                    .antMatchers("/api/**").hasAnyAuthority(Role.createRolesStringArray())
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                        .loginPage("/account/login")
                        .failureUrl("/account/login?error")
                        .defaultSuccessUrl("/account/info")
                        .usernameParameter("email")
                        .permitAll()
                        .and()
                .logout()
                    .logoutUrl("/account/logout")
                    .logoutSuccessUrl("/")
                    .permitAll();

    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }
}