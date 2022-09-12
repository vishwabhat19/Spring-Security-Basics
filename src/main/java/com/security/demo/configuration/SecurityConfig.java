package com.security.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();

        http.authorizeRequests()
                .antMatchers("/balance").authenticated()
                .antMatchers("/statement").authenticated()
                .antMatchers("/loan").authenticated()
                .antMatchers("/home").permitAll()
                .antMatchers("/contact").permitAll()
                .and().formLogin()
                .and().httpBasic();
    }

    /*
    Configuring multiple but limited users go for in-memory authentication
    Don't do this in case you have global users(use JDBC authentication)
    or if you have a lot of users in an organization ( use LDAP authentication)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("vishwa").password("Termite@2018").authorities("admin")
                .and()
                .withUser("raju").password("raju123").authorities("read")
                .and()
                .withUser("mahesh").password("mahesh123").authorities("read")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
