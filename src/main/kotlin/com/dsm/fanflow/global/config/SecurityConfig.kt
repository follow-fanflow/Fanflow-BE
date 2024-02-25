package com.dsm.fanflow.global.config

import com.dsm.fanflow.global.domain.enum.Role
import com.dsm.fanflow.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val tokenProvider: JwtTokenProvider
) {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf().disable()
            .formLogin().disable()
            .cors()

            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeHttpRequests()

            .antMatchers("/user/signup").permitAll()
            .antMatchers("/user/login").permitAll()
            .antMatchers(HttpMethod.GET).permitAll()
            .antMatchers("/schedule/admin/**").hasRole(Role.ADMIN.toString())
            .antMatchers("/place/admin/**").hasRole(Role.ADMIN.toString())
            .anyRequest().authenticated()

            .and().apply(FilterConfig(objectMapper, tokenProvider))
            .and().build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}