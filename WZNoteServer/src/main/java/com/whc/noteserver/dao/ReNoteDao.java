package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;

public interface ReNoteDao {

	/**
	 * 获取记录数
	 * 
	 * @return
	 */
	public int getCount(ReNoteParam param);

	/**
	 * 获取已删除的笔记信息
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param);

	/**
	 * 还原笔记
	 * 
	 * @param Note 要删除的笔记
	 * @return
	 */
	public int reNote(ReNote Note);
	
	/**
	 * 彻底删除笔记
	 * 
	 * @param Note 要删除的笔记
	 * @return
	 */
	public int deleteNote(ReNote Note);
}
