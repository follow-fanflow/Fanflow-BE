package com.dsm.fanflow.global.security.jwt

import com.dsm.fanflow.global.auth.AuthDetailsService
import com.dsm.fanflow.global.security.domain.RefreshToken
import com.dsm.fanflow.global.security.domain.repository.RefreshTokenRepository
import com.dsm.fanflow.global.security.dto.response.TokenResponse
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.Date
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    companion object {
        private const val ACCESS = "access_token"
        private const val REFRESH = "refresh_token"
    }

    fun generateToken(accountId: String): TokenResponse {
        val accessToken: String = generateAccessToken(accountId, ACCESS, jwtProperties.accessExp)
        val refreshToken: String = generateRefreshToken(REFRESH, jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(accountId, refreshToken, jwtProperties.refreshExp)
        )
        return TokenResponse(accessToken, refreshToken)
    }

    private fun generateAccessToken(accountId: String, typ: String, exp: Long): String {
        return Jwts.builder()
            .setSubject(accountId)
            .claim("typ", typ)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    private fun generateRefreshToken(type: String, ttl: Long): String {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setHeaderParam("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + ttl * 1000))
            .compact()
    }


    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getAccountId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getAccountId(token: String): String {
        return getClaims(token).subject
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw Exception()
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception()
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(jwtProperties.header)

        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)
            && bearerToken.length > jwtProperties.prefix.length + 1
        ) {
            bearerToken.substring(jwtProperties.prefix.length)
        } else null
    }
}