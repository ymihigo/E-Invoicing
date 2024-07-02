//package rw.invoicing.main.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigura extends WebSecurityConfiguration {
//	
//    // Authentication: In-memory user/password and roles setup
//   
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("normal").password("Password@123").roles("USER")
//            .and()
//            .withUser("admin").password("Password@123").roles("ADMIN");
//    }
//
//    // Authorization: Define URL-based security rules
//    
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .requestMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for /admin/**
//            .requestMatchers("/user/**").hasRole("USER")   // Require USER role for /user/**
//            .anyRequest().authenticated()              // All other URLs require authentication
//            .and()
//            .formLogin()                               // Enable form based login
//            .and()
//            .httpBasic();                              // Enable basic authentication
//    }
//}
