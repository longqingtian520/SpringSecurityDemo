package com.criss.wang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Many;

import com.criss.wang.entity.Hr;
import com.criss.wang.entity.Role;

@Mapper
public interface HrMapper {

	@Select("select * from hr WHERE username=#{username}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "telephone", property = "telephone"),
		@Result(column = "address", property = "address"),
		@Result(column = "enabled", property = "enabled"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "userface", property = "userface"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "id", property = "roles", many = @Many(select = "getRolesByHrId"))
	})
	public Hr loadUserByUsername(@Param("username") String username);
	
	@Select("SELECT r.* FROM hr_role h,role r where h.rid=r.id AND h.hrid=#{id}")
	public List<Role> getRolesByHrId(@Param("id") Integer id);
	
//	@Select("select * from hr WHERE username=#{username}")
//	public Hr loadUserByUsername(@Param("username") String username);

}
