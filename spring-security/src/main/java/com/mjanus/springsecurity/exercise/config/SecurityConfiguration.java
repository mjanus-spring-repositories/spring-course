package com.mjanus.springsecurity.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.inMemoryAuthentication().withUser("r1").password("r1").roles("R1");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("r2").password("r2").roles("R2");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("r3").password("r3").roles("R3");
        return authenticationManagerBuilder.build();
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/movie/**")
                .hasAnyRole("R1", "R2", "R3")
                .requestMatchers(HttpMethod.POST, "/**")
                .hasAnyRole("R2", "R3")
                .requestMatchers(HttpMethod.DELETE, "/**")
                .hasAnyRole("R3")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();

        return http.build();
    }
}
