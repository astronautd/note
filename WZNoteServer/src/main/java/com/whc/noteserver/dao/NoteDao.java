package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;

public interface NoteDao {

	/**
	 * 获取记录数
	 * 
	 * @return
	 */
	public int getCount(NoteParam param);

	/**
	 * 获取笔记信息
	 * 
	 * @return
	 */
	public List<NoteResult> getNote(NoteParam param);

	/**
	 * 添加笔记信息
	 * 
	 * @param Note 要添加的笔记
	 * @return
	 */
	public int addNote(Note note);

	/**
	 * 查询单个笔记信息
	 * 
	 * @param Note 根据Note的id
	 * @return
	 */
	public List<Note> getNoteDetail(Note Note);

	/**
	 * 更新笔记信息
	 * 
	 * @param Note 要更新的笔记
	 * @return
	 */
	public int updateNote(Note Note);

	/**
	 * 删除笔记
	 * 
	 * @param Note 要删除的笔记
	 * @return
	 */
	public int deleteNote(Note Note);
}
