package com.mailorderpharmacy.authservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * The Class UserData.
 */
// Model class for the business details

/**
 * Gets the auth token.
 *
 * @return the auth token
 */
@Getter

/**
 * Sets the auth token.
 *
 * @param authToken the new auth token
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString

/**
 * Instantiates a new user data.
 */
@NoArgsConstructor

/**
 * Instantiates a new user data.
 *
 * @param userid the userid
 * @param upassword the upassword
 * @param uname the uname
 * @param authToken the auth token
 */
@AllArgsConstructor
@Entity(name = "user")
@Table
public class UserData {

	/** The userid. */
	// Id for user 
	@Id
	@Column(name = "userid", length = 30)
	private String userid;
	
	/** The upassword. */
	// Password for user
	@Column(name = "upassword", length = 30)
	private String upassword;
	
	/** Name for user. */
	@Column(name = "uname", length = 30)
	private String uname;
	
	/** The auth token. */
	// Generated authentication token for the user
	private String authToken;
	
	
	
	
	
}

