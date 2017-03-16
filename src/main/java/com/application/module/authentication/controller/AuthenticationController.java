/**
 * 
 */
package com.application.module.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.module.authentication.bean.JwtAuthenticationRequest;
import com.application.module.authentication.service.JwtUserDetailsService;
import com.application.module.authentication.serviceimpl.JwtAuthenticationResponse;
import com.application.module.authentication.util.JwtTokenUtil;

/**
 * @author AmitAgarwal
 *
 */

@Controller
public class AuthenticationController {
	
	
	@Autowired
	@Qualifier("jwtUserDetailService")
	private JwtUserDetailsService jwtUserDetailService;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Value("Authentication")
    private String tokenHeader;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value = "/auth",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createAuthentication(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) throws AuthenticationException{

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		jwtAuthenticationRequest.getUserName(),
                		jwtAuthenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(jwtAuthenticationRequest.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return new ResponseEntity<Object>(new JwtAuthenticationResponse(token), HttpStatus.OK);
    }

}
