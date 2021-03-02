package net.asforil.AtmWeb.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	
	

	
	@Override
	  protected void configure(HttpSecurity http) throws Exception  {
		http
		      .authorizeRequests() 		      
		          .antMatchers("/home").permitAll()		          		          
                  .anyRequest().authenticated()
                  .and()
              .formLogin()                   
                  .defaultSuccessUrl("/atms")
                  .failureUrl("/login?error=true")
                  .permitAll()
                  .and()
              .logout()
                  .permitAll();
		
		
		
		
	}
	
	// create a demo user in memory with username=user and password=user and role=USER
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.withDefaultPasswordEncoder()    // no for production				
				               .username("user")				
				               .password("user")
				               .roles("USER")
				               .build();

		return new InMemoryUserDetailsManager(user);
	}
	
	

}
