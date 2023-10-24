package com.librarySystem.Security;

import com.librarySystem.Models.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/librarian/**").hasRole(String.valueOf(Role.LIBRARIAN))
//                .requestMatchers("").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//        return http.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Replace this with your actual user retrieval logic (e.g., from a database)
//        UserDetails librarianUser = new User("librarian", "password", Role.LIBRARIAN);
//        UserDetails patronUser = new User("patron", "password", Role.PATRON);
//
//        return new InMemoryUserDetailsManager(librarianUser, patronUser);
//    }
}

