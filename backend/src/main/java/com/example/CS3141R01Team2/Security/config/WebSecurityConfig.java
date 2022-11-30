package com.example.CS3141R01Team2.Security.config;

import com.example.CS3141R01Team2.Users.UserRole;
import com.example.CS3141R01Team2.Users.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsersService usersService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomFilter customFilter = new CustomFilter();
        customFilter.setAuthenticationManager(authenticationManager());

        http
                .csrf().disable()
                .addFilterAt(
                        customFilter,
                        UsernamePasswordAuthenticationFilter.class
                )
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/registration/**").permitAll()
//                .antMatchers("/users/**", "/studyset/**", "/terms/**").permitAll()
//                .antMatchers("/users/").hasRole("USER")
                .anyRequest().authenticated()


                .and()
                .formLogin()
//                .loginPage("http://localhost:3000").permitAll()
//                .loginProcessingUrl("/login")
//                .successHandler(myAuthenticationSuccessHandler())
                .defaultSuccessUrl("/users/showusers", true)
        ;
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usersService);
        return provider;
    }
}