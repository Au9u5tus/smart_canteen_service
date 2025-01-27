package com.yuhao.smart_canteen.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtils {
    private static final String SECRET_KEY = "yuhao";
    private static final long EXPIRATION_TIME = 1000 * 60 * 30; // 30分钟有效期

    // 生成 JWT
    public static String generateToken(String username) {
        Key key = new SecretKeySpec(new String(SECRET_KEY).getBytes(), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

    // 验证 JWT 并解析出用户名
    public static String validateTokenAndGetUsername(String token) {
        Key key = new SecretKeySpec(new String(SECRET_KEY).getBytes(), SignatureAlgorithm.HS256.getJcaName());
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}
