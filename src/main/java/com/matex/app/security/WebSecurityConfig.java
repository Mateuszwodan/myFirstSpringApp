package com.matex.app.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import com.matex.app.service.MyDBAutenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyDBAutenticationService myDBAauthenticationService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/index.html", "/css/**", "/fonts/**", "/js/**", "/main/**", "/#/main/login",
					"/saveUser","/getUsers")
				.permitAll()
				.antMatchers("/login")
				.permitAll()
				.anyRequest()
				.permitAll()
				.and()
				.formLogin()
				.loginProcessingUrl("/login")
				.permitAll()
				.and()
				.csrf()
				.disable();
		
		        http.headers().frameOptions().sameOrigin();
		    
	}

	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(myDBAauthenticationService);
	 }
}
