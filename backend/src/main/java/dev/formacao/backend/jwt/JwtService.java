package dev.formacao.backend.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String segredo;

    @Value("${jwt.expiration}")
    private Integer expiracao;

    public String gerarToken(String email) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.create().withIssuer("Backend").withSubject(email).sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro inesperado");
        }
    }

    public String decodificarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm).withIssuer("Backend").build().verify(token).getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro inesperado");
        }
    }
}
