package com.mjkj.mioa.web.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").permitAll();
		http.authorizeRequests().antMatchers("/")
				.permitAll().anyRequest().authenticated()
//				.and().csrf().csrfTokenRepository(csrfTokenRepository())
//				.and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
				.and().logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/tosignout")
				.and().exceptionHandling().accessDeniedPage("/deny");
	}

	private Filter csrfHeaderFilter() {
		return new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
				CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
				if (csrf != null) {
					Cookie cookie = new Cookie("XSRF-TOKEN", csrf.getToken());
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				filterChain.doFilter(request, response);
			}
		};
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		//解决静态资源被拦截的问题
	     web.ignoring().antMatchers("/common/**","/backstage/**/*.js","/backstage/**/*.css","/backstage/**/*.jpg","/backstage/**/*.gif","/backstage/**/*.png");
	}
}
