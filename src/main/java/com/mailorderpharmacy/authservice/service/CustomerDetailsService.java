package com.mailorderpharmacy.authservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mailorderpharmacy.authservice.dao.UserDAO;
import com.mailorderpharmacy.authservice.entity.UserData;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerDetailsService.
 */
// Service class
@Service
public class CustomerDetailsService implements UserDetailsService {
	
	/** The userdao. */
	@Autowired
	private UserDAO userdao;

	/**
	 * Load user by username.
	 *
	 * @param uid the uid
	 * @return the user details
	 */
	/*
	 * @param String
	 * @return User 
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String uid) {
		
		try
		{
			UserData custuser = userdao.findById(uid).orElse(null);
			if(custuser != null) {
				custuser.getUname();
			}
			return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
			
		
		
	}

}
