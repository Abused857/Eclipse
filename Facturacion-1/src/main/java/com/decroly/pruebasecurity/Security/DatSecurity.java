package com.decroly.pruebasecurity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DatSecurity {

	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	            .username("tomas")
	            .password("tomas")
	            .roles("ADMINISTRADOR")
	            .build();
	        return new InMemoryUserDetailsManager(user);
	    }

}
