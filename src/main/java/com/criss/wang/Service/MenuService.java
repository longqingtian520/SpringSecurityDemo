package com.criss.wang.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criss.wang.entity.Menu;
import com.criss.wang.mapper.MenuMapper;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public List<Menu> getAllMenu(){
		return menuMapper.getAllMenu();
	}
}
