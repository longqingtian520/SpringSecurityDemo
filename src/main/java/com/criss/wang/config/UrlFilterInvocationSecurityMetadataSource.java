package com.criss.wang.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.criss.wang.Service.MenuService;
import com.criss.wang.entity.Menu;
import com.criss.wang.entity.Role;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private MenuService menuService;

	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation)obj).getRequestUrl();
		if("/login_p".equals(requestUrl)) {
			return null;
		}
		List<Menu> allMenu = menuService.getAllMenu();
		for(Menu menu : allMenu) {
			if(antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
				List<Role> roles = menu.getRoles();
				int size = roles.size();
				String[] values = new String[size];
				for(int i = 0; i <size; i++) {
					values[i] = roles.get(i).getName();
				}
				return SecurityConfig.createList(values);
			}
		}
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(arg0);
	}

}
