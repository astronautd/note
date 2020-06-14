package com.whc.noteserver.service;

import java.util.List;

import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;

public interface ReNoteService {

	public int getCount(ReNoteParam param);

	/**
	 * 获取笔记信息
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param);

	/**
	 * 还原笔记
	 * 
	 * @param Note 要还原的笔记
	 * @return
	 */
	public int reNote(ReNote note);
	
	/**
	 * 彻底删除笔记
	 * 
	 * @param Note 要彻底删除的笔记
	 * @return
	 */
	public int deleteNote(ReNote note);

}
