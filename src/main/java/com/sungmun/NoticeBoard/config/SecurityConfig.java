package com.sungmun.NoticeBoard.config;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sungmun.NoticeBoard.service.LoginSuccessHandler;
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
			.successHandler(successHandler())
			.failureUrl("/login")
		.and()
			.logout();

		http.headers().frameOptions().disable();

	}

	public AuthenticationSuccessHandler successHandler() {
		return new LoginSuccessHandler("/");
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}
}
