package com.example.lezhin.global.security.jwt;

import com.example.lezhin.domain.user.domain.User;
import com.example.lezhin.global.error.exception.ErrorCode;
import com.example.lezhin.global.security.jwt.dto.TokenResponse;
import com.example.lezhin.global.security.principle.AuthDetailsService;
import com.example.lezhin.global.error.exception.BusinessException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer";
    private final AuthDetailsService authDetailsService;
    @Value("${spring.jwt.key}")
    private String key;

    @Value("${spring.jwt.live.accessToken}")
    private Long accessTokenTime;

    @Value("${spring.jwt.live.refreshToken}")
    private Long refreshTokenTime;

    @PostConstruct
    protected void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    public TokenResponse getToken(User user) {
        String accessToken = generateAccessToken(user.getUserEmail());

        return new TokenResponse(accessToken, accessTokenTime);
    }
    public String generateAccessToken(String email) {
        return generateToken(email, "access", accessTokenTime);
    }

    private String generateToken(String email, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .setSubject(email)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(HEADER);
        return parseToken(bearer);
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenSubject(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(PREFIX))
            return bearerToken.replace(PREFIX, "");

        return null;
    }

    private Claims getTokenBody(String token) {

        try {
            return Jwts.parser().setSigningKey(key.getBytes())
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.JWT_EXPIRED);
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

}