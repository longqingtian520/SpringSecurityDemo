package com.criss.wang.entity;

public class Role {
	private Long id;
	private String name;
	private String nameZh;
	public Role() {
		super();
	}
	public Role(Long id, String name, String nameZh) {
		super();
		this.id = id;
		this.name = name;
		this.nameZh = nameZh;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
}
