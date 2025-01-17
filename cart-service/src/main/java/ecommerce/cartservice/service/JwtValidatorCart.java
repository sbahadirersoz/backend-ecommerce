package ecommerce.cartservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtValidatorCart
{
    @Value("${secret}")
    String Secret;
    @Value("${expire}")
    Long expire;
    private Claims extractAllClaims(String token) {
        Claims claims =
        Jwts
        .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        if (claims.getExpiration().before(new Date()))
        {
         throw new RuntimeException("Expired");
        }
        return claims;
    }
    public String getUsernameFromToken (String token)
    {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }
    private SecretKey getSignInKey()
    {
        byte[] kBytes = Decoders.BASE64.decode(Secret);
        return Keys.hmacShaKeyFor(kBytes);
    }



}
