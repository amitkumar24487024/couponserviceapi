package com.coupon.repos.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CouponSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder ;
	
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
	}

	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserDetails user = User.withUsername("amit").password(passwordEncoder.encode("24487024")).authorities("read").build();
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		userDetailsService.createUser(user);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	*/
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	


}
