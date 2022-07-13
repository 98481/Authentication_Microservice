package com.mailorderpharmacy.authservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtUtil.
 */
// Service class
@Service
public class JwtUtil {

	/** The secretkey. */
	private String secretkey = "${jwt.secret}";

	/**
	 * Extract username.
	 *
	 * @param token the token
	 * @return the string
	 */
	/*
	 * @param token
	 * @return
	 */
	public String extractUsername(String token) {
		
		return extractClaim(token, Claims::getSubject);
				
	}

	/**
	 * Extract claim.
	 *
	 * @param <T> the generic type
	 * @param token the token
	 * @param claimsResolver the claims resolver
	 * @return the t
	 */
	/*
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	
	}

	/**
	 * Extract all claims.
	 *
	 * @param token the token
	 * @return the claims
	 */
	/*
	 * @param token
	 * @return
	 */
	private Claims extractAllClaims(String token) {
		
			return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			
	}

	/**
	 * Generate token.
	 *
	 * @param userDetails the user details
	 * @return the string
	 */
	/*
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * Creates the token.
	 *
	 * @param claims the claims
	 * @param subject the subject
	 * @return the string
	 */
	/*
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15*10))  // token for 15 min
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		
	}

	/**
	 * Validate token.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	/*
	 * @param token
	 * @return
	 */
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}
}