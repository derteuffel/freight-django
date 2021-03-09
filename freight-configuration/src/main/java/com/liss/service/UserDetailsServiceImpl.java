package com.liss.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.springframework.stereotype.Service;

import com.liss.entities.management.RoleEntity;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/{


	
/*    @Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) {
    	
	    	UserEntity user = userRepository.findByUsername(username);
	    	if(user == null) {
	    		System.err.println("Cette Utilisateur ne peut se connecter contacter l'administarteur -- Not Found");
				throw new UsernameNotFoundException("Not Found User");
	    	}
	    	
	    	if (!user.getEnable()) {
	        	System.err.println("Cette Utilisateur ne peut se connecter contacter l'administarteur -- is Disable");
				throw new UsernameNotFoundException("USER LOCK");
	        }
	        List<GrantedAuthority> authorities = buildUserAuthority(Arrays.asList(user.getRole()));
			//if you're implementing UserDetails you wouldn't need to call this method and instead return the User as it is
	        return buildUserForAuthentication(user, authorities);
	
    
    }*/
    
    // Converts user to spring.springframework.security.core.userdetails.User
/*    private User buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
    	boolean enabled = user.getEnable();
        return new User(user.getLogin(), user.getPassword(), enabled, true, true, true, authorities);
    }*/
/*
    private List<GrantedAuthority> buildUserAuthority(List<RoleEntity> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // add user's authorities
        for (RoleEntity userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getCode()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }*/
	

}
