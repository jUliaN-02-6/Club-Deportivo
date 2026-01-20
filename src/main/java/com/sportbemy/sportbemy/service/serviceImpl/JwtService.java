package com.sportbemy.sportbemy.service.serviceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    // Traemos los valores que pusiste en application.properties
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration}")
    private long jwtExpiration;

    // MÉTODO PRINCIPAL: Generar el token para un usuario
    public String generateToken(String email) {
        return buildToken(new HashMap<>(), email);
    }

    // Construye el token con "claims" (datos extra), fecha de inicio, fin y firma
    private String buildToken(Map<String, Object> extraClaims, String email) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(email) // El "Dueño" del token (el email)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de creación: AHORA
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration)) // Expira en 1 día
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Firmamos con tu clave secreta
                .compact();
    }

    // Decodifica tu clave secreta para que Java la pueda usar
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        // Si tu clave es texto plano simple, a veces es mejor usar getBytes directamente:
        // return Keys.hmacShaKeyFor(secretKey.getBytes());
        // Pero intentemos primero con el decodificador estándar.
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}