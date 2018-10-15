package com.sungmun.NoticeBoard.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sungmun.NoticeBoard.service.MemberService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	MemberService service;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/ckeditor5/**", "lib/**", "/h2-console/*");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN").antMatchers("/**").permitAll()
		.and()
			.formLogin().loginPage("/login")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login")
		.and()
			.logout();

		http.headers().frameOptions().disable();

	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}
}
