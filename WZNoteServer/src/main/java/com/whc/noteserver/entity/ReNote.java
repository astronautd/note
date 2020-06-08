package com.whc.noteserver.entity;

import java.io.Serializable;

public class ReNote implements Serializable {

	private static final long serialVersionUID = -1884502868921125599L;
	public static int DELETE_YES = 1;
	public static int DELETE_NO = 0;
	private String id; // id
	private String name;// ±Ê¼ÇÃû³Æ
	private int isdelete;// ÊÇ·ñÉ¾³ý±êÖ¾£¬0-Î´É¾³ý£¬1-É¾³ý

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}


	@Override
	public String toString() {
		return "NoteBook [id=" + id + ", name=" + name + ", isdelete=" + isdelete + ", userid="
				+ "]";
	}

}
