package com.ethercraft.security;

import com.ethercraft.property.JwtProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Resource
    private final JwtProperty jwtProperty;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtProperty.getSecret()));
    }

    public String generateToken(Long userId, String username) {
        return Jwts.builder()
                .subject(username)
                .claim("userId",userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtProperty.getExpire()))
                .signWith(getKey())
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Long getUserId(String token) {
        return parseToken(token).get("userId", Long.class);
    }

    public String getUsername(String token) {
        return parseToken(token).getSubject();
    }

    public Long getExpire() {
        return jwtProperty.getExpire();
    }

}
