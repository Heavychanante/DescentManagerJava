//package org.descentmanager.config;
//
//import org.descentmanager.filter.CsrfHeaderFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//
//@Configuration
//@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/login").permitAll()
//			.anyRequest().authenticated().and().csrf().csrfTokenRepository(csrfTokenRepository()).and()
//			.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
//		http
//			.authorizeRequests()
//				.antMatchers("/index.html", "/", "/login").permitAll()
//				.antMatchers("/static/**").permitAll()
//				.anyRequest().authenticated()
//			.and()
//				.formLogin()
//				.loginProcessingUrl("/login")
//			.and()
//				.logout()
//				.logoutUrl("/logout")
//			.and()
//				.csrf().csrfTokenRepository(csrfTokenRepository())
//			.and()
//				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
//    }
//
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//        	.userDetailsService(userDetailsService)
//            .passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//	private CsrfTokenRepository csrfTokenRepository() {
//		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		repository.setHeaderName("X-XSRF-TOKEN");
//		return repository;
//	}
//}
