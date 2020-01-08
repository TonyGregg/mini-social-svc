package com.genil.learning.minisocialsvc.tms.security;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

/**
 * Created by Antony Genil Gregory on 1/8/2020 5:05 AM
 * For project : mini-social-svc
 **/
@Service
public class SecurityServiceImpl implements SecurityService {
    private static final String SECRET_KEY = "4C8kum4LxyKWYLM78sKdXrzbBjZBFydk";
    @Override
    public String createToken(String subject, long ttlMillis) {
        if (ttlMillis <= 0) throw new RuntimeException("Expirty time must be greater than Zero: ["+ttlMillis+"]");
        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);
        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));
        return builder.compact();
    }

    @Override
    public String getSubject(String token) {
        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
