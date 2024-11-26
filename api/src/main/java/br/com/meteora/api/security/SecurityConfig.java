package br.com.meteora.api.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         
       http.authorizeHttpRequests( auth -> auth
       .requestMatchers("/index","/sobre","/contato").permitAll()
       .anyRequest().authenticated())
        
        .formLogin(form -> form
        .loginPage("/login")
        .defaultSuccessUrl("/", true)
        .failureUrl("/login-error")
        .permitAll())

        .logout(logout -> logout
        .logoutSuccessUrl("/"));
        



        
        
        
        
        return http.build();
    }
}
