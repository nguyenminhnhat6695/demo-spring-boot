package com.laptrinhjavaweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//	}
	
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
  }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http.csrf().disable()
            .authorizeRequests()
            	//.antMatchers(HttpMethod.POST,"/login/**").permitAll()
                .antMatchers("/template/**", "/registration","/admin/").permitAll()
                .antMatchers("/").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("USER")
                .anyRequest().authenticated() // T???t c??? c??c request g???i t???i Web Server y??u c???u ph???i ???????c x??c th???c
             .and()
             	.formLogin()
                .loginPage("/login").permitAll()
             .and()
             	.logout().permitAll()
             .and().exceptionHandling().accessDeniedPage("/access-denied");
                //.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
                //.and()
                //.exceptionHandling().authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint()); // X??? l?? tr?????c khi login - c?? th??? tr??? ?????n trang ch??? c??ng ??c r???i sau ???? m???i login
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/template/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}

}
