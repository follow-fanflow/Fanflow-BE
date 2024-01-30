package com.dsm.fanflow.global.security.domain.repository

import com.dsm.fanflow.global.security.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, Long>
