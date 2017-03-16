package com.application.module.authentication.serviceimpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.application.module.authentication.service.JwtUserDetailsService;

public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}
