package com.dsm.fanflow.global.config

import com.dsm.fanflow.global.error.ExceptionFilter
import com.dsm.fanflow.global.security.jwt.JwtTokenFilter
import com.dsm.fanflow.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.access.intercept.AuthorizationFilter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val tokenProvider: JwtTokenProvider
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {

        val tokenFilter = JwtTokenFilter(tokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)

        builder.run {
            addFilterBefore(exceptionFilter, AuthorizationFilter::class.java)
            addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        }
    }
}