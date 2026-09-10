package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin= User.builder()
				.username("admin")
				.password(encoder.encode("admin123"))
				.roles("ADMIN").build();
		UserDetails trainer= User.builder()
				.username("trainer")
				.password(encoder.encode("trainer123"))
				.roles("TRAINER").build();
		UserDetails student= User.builder()
				.username("student")
				.password(encoder.encode("student123"))
				.roles("STUDENT").build();
		return new InMemoryUserDetailsManager(admin,trainer,student);
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> 
		auth.requestMatchers("/login").permitAll()
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/student/**").hasRole("STUDENT")
		.requestMatchers("/trainer/**").hasAnyRole("TRAINER","ADMIN")
		
		.anyRequest().authenticated())
		.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/home",true).permitAll())
		.logout(logout -> logout.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout").permitAll())
		.exceptionHandling(ex -> ex.accessDeniedPage("/access-denied"))		
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}

}
