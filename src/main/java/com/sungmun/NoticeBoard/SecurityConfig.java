package com.sungmun.NoticeBoard;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/ckeditor5/**","lib/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/").usernameParameter("id").passwordParameter("password");
		
		http.authorizeRequests().antMatchers("/h2-console/*").permitAll();
		http.headers().frameOptions().disable();
	}
}
