package com.criss.wang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.criss.wang.entity.Menu;

@Mapper
public interface MenuMapper {

	@Select("select m.*,r.`id` as rid,r.`name` as rname,r.`nameZh` as rnamezh from menu m left join menu_role mr on m.`id`=mr.`mid` left join role r on mr.`rid`=r.`id` "
			+ " WHERE m.`enabled`=true order by m.`id` desc")
	public List<Menu> getAllMenu();
}
