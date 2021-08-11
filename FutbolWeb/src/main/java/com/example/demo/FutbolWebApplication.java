package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.demo.security.JWTAuthorizationFilter;

@SpringBootApplication
public class FutbolWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbolWebApplication.class, args);
	}
	
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/Usuario/login").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/Usuario/login").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/**/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/Partido/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/Partido/listar").permitAll()
				.anyRequest().authenticated();
		}
	}

}
