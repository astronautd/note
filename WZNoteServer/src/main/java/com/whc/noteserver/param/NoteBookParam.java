package com.whc.noteserver.param;

import com.whc.noteserver.entity.NoteBook;

public class NoteBookParam extends NoteBook{
	
	private int page;
	private int limit;
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
