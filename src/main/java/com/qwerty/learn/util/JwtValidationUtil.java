package com.qwerty.learn.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtValidationUtil {

	 private static final String SECRET_KEY = "secretKey";
	 
		public boolean validateAccessToken(String token) {
			try {
				Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
				return true;
			} catch (ExpiredJwtException ex) {
				System.out.println("JWT expired" + ex.getMessage());
			} catch (IllegalArgumentException ex) {
				System.out.println("Token is null, empty or only whitespace" + ex.getMessage());
			} catch (MalformedJwtException ex) {
				System.out.println("JWT is invalid" + ex);
			} catch (UnsupportedJwtException ex) {
				System.out.println("JWT is not supported" + ex);
			} catch (SignatureException ex) {
				System.out.println("Signature validation failed");
			}

			return false;
		}
}
