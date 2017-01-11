package com.matex.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
	}

	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(myDBAauthenticationService);
	 }
}
