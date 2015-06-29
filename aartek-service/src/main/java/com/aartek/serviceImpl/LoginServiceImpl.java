package com.aartek.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aartek.model.UserRole;
import com.aartek.repository.LoginRepository;

/**
 * 
 * @author Vivek, 17/04/2015, LoginServiceImpl for creating authority
 *
 */
@Service("userDetailsService")
public class LoginServiceImpl implements UserDetailsService {
	@Autowired
	private LoginRepository loginRepository;

	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		com.aartek.model.User user = loginRepository.findByUserName(userName);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	/**
	 * 
	 * @param user
	 * @param authorities
	 * @return
	 */
	private User buildUserForAuthentication(com.aartek.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	/**
	 * 
	 * @param userRole
	 * @return
	 */
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRole) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (UserRole userRoles : userRole) {
			setAuths.add(new SimpleGrantedAuthority(userRoles.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}
}
