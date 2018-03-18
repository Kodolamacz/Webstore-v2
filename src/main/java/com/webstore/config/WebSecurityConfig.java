package com.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Created by Blazej on 11.03.2018.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.webstore.*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/registration").permitAll().anyRequest().authenticated()
                .and()
        .authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")

                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login").successForwardUrl("/welcome").permitAll()
                .and()
                .csrf().disable();
    }
}
