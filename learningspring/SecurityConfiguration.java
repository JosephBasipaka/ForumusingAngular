package com.prodapt.learningspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import com.prodapt.learningspring.service.CustomUserDetailsService;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService);
    }

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/forum/register", "/error", "/api/post/{id}", "/api/**").permitAll()
                .anyRequest().authenticated())
            .logout(withDefaults());
//            .formLogin(withDefaults());

        return http.build();
    }
}
