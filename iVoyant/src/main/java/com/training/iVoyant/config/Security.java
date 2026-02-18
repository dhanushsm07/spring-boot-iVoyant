//package com.training.iVoyant.config;
//
//import org.springframework.boot.security.autoconfigure.actuate.web.servlet.EndpointRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class Security {
//
//    @Bean
//    public SecurityFilterChain security(HttpSecurity ht)throws Exception{
////        ht
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(EndpointRequest.to("health")).permitAll()
////                        .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
////                        .anyRequest().permitAll()
////                )
////                .httpBasic(Customizer.withDefaults());
////        return ht.build();
//    }
//}
