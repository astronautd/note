package com.whc.noteserver.result;

import java.util.List;

import com.whc.noteserver.entity.NoteBook;

public class LayPage {
	
	private int count;    //共多少条
	List<NoteBook> list;    //一页显示的数据
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<NoteBook> getList() {
		return list;
	}
	public void setList(List<NoteBook> list) {
		this.list = list;
	}

}
