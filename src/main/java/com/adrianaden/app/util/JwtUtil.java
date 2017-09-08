package com.adrianaden.app.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adrianaden.app.exception.JwtExceptionHandler;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {

	@Value("${secret.key}")
	private String secretKey;

	public String createJWT(String id, String issuer, String subject, long ttlMillis) {
		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	// Sample method to validate and read the JWT
	private Claims parseJWT(String jwt) {
		Claims claims;
		// This line will throw an exception if it is not a signed JWS (as expected)
		try {
			claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
					.parseClaimsJws(jwt)
					.getBody();

		} catch (Exception e) {
			log.info("Failed parse JWT token: " + jwt);
			claims = null;
		}

		return claims;
	}

	public boolean isValidJWT(String jwt) {
		return this.parseJWT(jwt) != null;
	}
}
