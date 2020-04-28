package com.whc.noteserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whc.noteserver.entity.NoteBook;

public interface NoteBookService {
	
	/**
	 * 获取笔记本信息
	 * @return
	 */
	public List<NoteBook> getNoteBook();
	
	/**
	 * 添加笔记本信息
	 * @param noteBook 要添加的笔记本
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook);
	
	/**
	 * 查询单个笔记本信息
	 * @param noteBook 根据noteBook的id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook);
	
	/**
	 *更新笔记本信息
	 * @param noteBook 要更新的笔记本
	 * @return 
	 */
	public int updateNoteBook(NoteBook noteBook);
	
	/**
	 * 删除笔记本信息
	 * @param noteBook 要删除的笔记本
	 * @return 
	 */
	public int deleteNoteBook(NoteBook noteBook);

}
