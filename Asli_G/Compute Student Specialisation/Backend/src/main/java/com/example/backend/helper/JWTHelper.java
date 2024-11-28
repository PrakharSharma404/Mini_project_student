package com.example.backend.helper;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTHelper {

    private String SECRET_KEY = "a840aed325630dbe8bfbefd1067e8468cf64610fbd14022a2622b4cacc65749aaad0240599afd7565fb399385d8a3b77582f317a788cf8a5ad046f3922c46b0bf166d34c492075f44a90aab13d0bced9dddac82712c1c125886f983a5f8633ba021ac250dca94f11edca2231d2e49017da528606207a3ee5c876517e31bcefd4176317033ecfc80825fccd21fce30d121325c24fb52d6c6f7f8ed40f39ed9a475be361c71ead7c1a2cca6ec77a6de1c4fce900d6fec8489d0d7e53ac01f2e7fd367a325a3d7e0778e94f1e3932bd612885677764ba3271e8fa29a0cf9412a4d34dbbceeb1a3cc683f3205f9fba54b6524e7654bc30510489b22a8643b0cc167b";

    // Extract username from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract claims
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // Check if token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // Create token with claims
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // Validate token
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}