package theatre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET,"/theatre-stages", "/performance-sessions/available",
                        "/performance-sessions/{id}", "/performances").permitAll()
                .antMatchers(HttpMethod.POST,"/theatre-stages", "/performances",
                        "/performance-sessions").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/performance-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/performance-sessions/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/orders", "/shopping-carts/by-user").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/orders/complete",
                        "/shopping-carts/performance-sessions").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/users/by-email").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
