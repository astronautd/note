package com.whc.noteserver.param;

import com.whc.noteserver.entity.Note;

public class NoteParam extends Note{
	private String userid;
	private int page;
	private int limit;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	

}
