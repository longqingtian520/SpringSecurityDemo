package com.criss.wang.common;

import org.springframework.security.core.context.SecurityContextHolder;

import com.criss.wang.entity.Hr;

public class HrUtils {
	public static Hr getCurrentHr() {
		return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
