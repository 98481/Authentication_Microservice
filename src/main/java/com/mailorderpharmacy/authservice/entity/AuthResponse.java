package com.mailorderpharmacy.authservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * Checks if is valid.
 *
 * @return true, if is valid
 */
@Getter

/**
 * Sets the valid.
 *
 * @param isValid the new valid
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString

/**
 * Instantiates a new auth response.
 */
@NoArgsConstructor

/**
 * Instantiates a new auth response.
 *
 * @param uid the uid
 * @param name the name
 * @param isValid the is valid
 */
@AllArgsConstructor
public class AuthResponse {
	
	/** The uid. */
	// Id for user
	private String uid;
	
	/** The name. */
	// Name of the user
	private String name;
	
	/** The is valid. */
	// Validity check
	private boolean isValid;

}
