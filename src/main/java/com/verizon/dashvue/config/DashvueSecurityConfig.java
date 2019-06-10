package com.verizon.dashvue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by mankaav on 7/11/2018.
 */
@Configuration
@Order(2147483640)
public class DashvueSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Bean
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// 	return super.authenticationManagerBean();
	// }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http
//      		.httpBasic()
//        .and()
//        	.authorizeRequests()
//			.antMatchers("/index.html", "/", "/home", "/login", "/*.bundle.*", "/*.js", "/*.css").permitAll()
//			.anyRequest().authenticated()
//		.and()
			.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

	// @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

}
