//package com.genil.learning.minisocialsvc.security;
//
//import com.okta.spring.boot.oauth.Okta;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by Antony Genil Gregory on 12/25/2019 12:26 PM
// * For project : mini-social-svc
// **/
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().
//                anyRequest().authenticated().
//                and().oauth2ResourceServer().jwt();
//        Okta.configureResourceServer401ResponseBody(http);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .passwordEncoder(encoder)
//                .withUser("spring")
//                .password(encoder.encode("secret"))
//                .roles("USER");
//    }
//}
