package com.criss.wang.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.criss.wang.entity.Hr;
import com.criss.wang.mapper.HrMapper;

@Service
public class HrService implements UserDetailsService{

	@Autowired
	private HrMapper hrMapper;
	@Override
	public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
		Hr hr = hrMapper.loadUserByUsername(str);
		if(hr == null) {
			throw new RuntimeException("用户名不正确");
		}
		return hr;
	}
	
	
}
