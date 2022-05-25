package fr.cda.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] PUBLIC_MATCHERS = { "/", "/products", "/products/**", "/api/**", "/registration" };

	@Autowired
	private final UserDetailsService userDetailsService;

	@Autowired
	private final PasswordEncoder passwordEncoder;

	public WebSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers("/dist/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure(HttpSecurity http)");
		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/", true).permitAll()

				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll();
	}

}