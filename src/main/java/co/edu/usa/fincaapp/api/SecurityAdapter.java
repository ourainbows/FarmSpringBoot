package co.edu.usa.fincaapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(
                a -> a.antMatchers("/", "/error", "/webjars/**","/css/**").permitAll().anyRequest().authenticated())
                
                   .exceptionHandling(
                        e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                        
                    .logout(l -> l
                        .logoutSuccessUrl("/").permitAll())
                    
                    .csrf(c -> c
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))        
                .oauth2Login()
                .defaultSuccessUrl("/", true);
                    
                
        http.cors().and().csrf().disable();
    }
}
    
