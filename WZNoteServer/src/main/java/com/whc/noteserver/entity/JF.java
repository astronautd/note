package com.whc.noteserver.entity;

import java.io.Serializable;

public class JF implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1552647802351246246L;
	private String id;//id
	private int jf;//积分
	private String user_id;//用户id
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getJf() {
		return jf;
	}

	public void setJf(int jf) {
		this.jf = jf;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "JF [id=" + id + ", jf=" + jf + ", user_id=" + user_id + "]";
	}
	
	

}
