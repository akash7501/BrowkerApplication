package com.WithBroker.BrokerWebApplication.WebSecurityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfiguration {


    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    @Bean
    UserDetailsService userDetailsService()
    {
        UserDetails owner = User.withUsername("owner").password(passwordEncoder().encode("owner")).roles("USER").build();
        UserDetails user = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();

     return  new InMemoryUserDetailsManager(owner,user);
    }


}
