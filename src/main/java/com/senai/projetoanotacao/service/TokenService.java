package com.senai.projetoanotacao.service;

import com.senai.projetoanotacao.dto.request.LoginRequest;
import com.senai.projetoanotacao.dto.response.LoginResponse;
import com.senai.projetoanotacao.entity.UsuarioEntity;
import com.senai.projetoanotacao.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {

    private final BCryptPasswordEncoder bCryptEncoder;
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDencoder;
    private final UsuarioRepository usuarioRepository;

    private static long TEMPO_EXPIRACAO = 36000L;

    public LoginResponse gerarToken(
            @RequestBody LoginRequest loginRequest
    ){

        UsuarioEntity usuarioEntity = usuarioRepository
                .findByNomeUsuario(loginRequest.nomeUsuario())
                .orElseThrow(
                        ()->{
                            log.error("Erro, usuário não existe");
                            return new RuntimeException("Erro, usuário não existe");
                        }
                );

        if(!usuarioEntity.senhaValida(loginRequest, bCryptEncoder)){
            log.error("Erro, senha incorreta");
            throw new RuntimeException("Erro, senha incorreta");
        }

        Instant now = Instant.now();

        String scope = usuarioEntity.getPerfil().getNome();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("projeto1")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(TEMPO_EXPIRACAO))
                .subject(usuarioEntity.getId().toString())
                .claim("scope", scope)
                .build();

        var valorJWT = jwtEncoder.encode(
                        JwtEncoderParameters.from(claims)
                )
                .getTokenValue();

        return new LoginResponse(valorJWT, TEMPO_EXPIRACAO);


    }


    public String buscaCampo(String token, String claim) {
        return jwtDencoder
                .decode(token)
                .getClaims()
                .get(claim)
                .toString();
    }
}
