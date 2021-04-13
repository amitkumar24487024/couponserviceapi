package com.coupon.repos.controllers;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CouponSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserDetails user = User.withUsername("amit").password(passwordEncoder.encode("24487024")).authorities("read").build();
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		userDetailsService.createUser(user);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}


}
