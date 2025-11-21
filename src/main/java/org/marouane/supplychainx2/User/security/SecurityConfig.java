package org.marouane.supplychainx2.User.security;


import lombok.AllArgsConstructor;
import org.hibernate.query.sqm.tree.domain.SqmPluralPartJoin;
import org.marouane.supplychainx2.User.entity.User;
import org.marouane.supplychainx2.User.service.IAccountService;
import org.marouane.supplychainx2.User.service.Impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }


    @Bean
    public UserDetailsService userDetailsService(AccountServiceImpl accountService) {
        return email -> {
            User appUser = accountService.loadUserByUserEmail(email);
            if (appUser == null) {
                throw new UsernameNotFoundException("User not found");
            }

            return org.springframework.security.core.userdetails.User
                    .withUsername(appUser.getEmail())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole().name())
                    .build();
        };
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/public").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }


}
