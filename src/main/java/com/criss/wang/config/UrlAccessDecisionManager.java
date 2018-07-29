package com.criss.wang.config;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication auth, Object obj, Collection<ConfigAttribute> collection)
			throws AccessDeniedException, InsufficientAuthenticationException {
		Iterator<ConfigAttribute> iterator = collection.iterator();
		while(iterator.hasNext()) {
			ConfigAttribute ca = iterator.next();
			// 当前请求需要的权限
			String needRole = ca.getAttribute();
			if("ROLE_LOGIN".equals(needRole)) {
				if(auth instanceof AnonymousAuthenticationToken) {
					throw new BadCredentialsException("未登录");
				}
				else {
					return;
				}
			}
			// 当前用户所拥有的权限
			Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			for(GrantedAuthority authority : authorities) {
				if(authority.getAuthority().equals(needRole)) {
					return;
				}
			}
		}
		
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
