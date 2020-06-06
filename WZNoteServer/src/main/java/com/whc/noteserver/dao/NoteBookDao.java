package com.whc.noteserver.dao;

import java.util.HashMap;
import java.util.List;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;

public interface NoteBookDao {

	/**
	 * 获取记录数
	 * 
	 * @return
	 */
	public int getCount(NoteBookParam param);

	/**
	 * 获取笔记本信息
	 * 
	 * @return
	 */
	public List<NoteBook> getNoteBook(NoteBookParam param);

	/**
	 * 添加笔记本信息
	 * 
	 * @param noteBook 要添加的笔记本
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook);

	/**
	 * 查询单个笔记本信息
	 * 
	 * @param noteBook 根据noteBook的id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook);

	/**
	 * 更新笔记本信息
	 * 
	 * @param noteBook 要更新的笔记本
	 * @return
	 */
	public int updateNoteBook(NoteBook noteBook);

	/**
	 * 删除笔记本
	 * 
	 * @param noteBook 要删除的笔记本
	 * @return
	 */
	public int deleteNoteBook(NoteBook noteBook);

	/**
	 * 根据用户id获取所有笔记本信息
	 * 
	 * @param param
	 * @return
	 */
	public List<NoteBook> getAllNoteBookByUserId(NoteBookParam param);
}
