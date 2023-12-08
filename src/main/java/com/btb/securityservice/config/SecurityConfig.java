package com.btb.securityservice.config;

import com.btb.securityservice.security.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}

/*.csrf(csrf -> csrf.disable())
        //.authorizeRequests(authorizeRequests -> authorizeRequests.requestMatchers("/monitoring").permitAll())
        .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
        .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);*/
