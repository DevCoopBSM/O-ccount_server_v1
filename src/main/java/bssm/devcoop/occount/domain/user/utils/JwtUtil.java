package bssm.devcoop.occount.domain.user.utils;

import bssm.devcoop.occount.domain.user.User;
import bssm.devcoop.occount.domain.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static UserRepository userRepository;

    public static String createJwt(User u, String secretKey,
                                   Long exprTime) {
        Claims claims = Jwts.claims();

        claims.put("email", u.getEmail());
        claims.put("studentName", u.getStudentName());
        claims.put("codeNumber", u.getCodeNumber());

        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + exprTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
