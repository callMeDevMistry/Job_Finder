package com.project.JobFinder.Config;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/", "/home", "/JobProfileHome", "/SearchValue").permitAll()
            .requestMatchers("/login", "/login/User", "/login/Admin").permitAll()
            .requestMatchers("/ApplyForJob").hasAnyRole("USER")
            .requestMatchers("/newJob", "/addNewJob").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        );
			return http.build();
	}
	

	 @Bean
	 public UserDetailsService userDetailsService(){
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("password")
	                .roles("USER")
	                .build();
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                .username("admin")
	                .password("password")
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user,admin);
	    }

}
