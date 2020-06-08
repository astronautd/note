package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteDao;
import com.whc.noteserver.dao.ReNoteDao;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.service.ReNoteService;

@Service
public class ReNoteImpl implements ReNoteService {

	@Autowired
	ReNoteDao renoteDao;

	public int getCount(ReNoteParam param) {
		return renoteDao.getCount(param);
	}

	/**
	 * 获取已删除的笔记信息
	 * 
	 * @return
	 */
	public List<DelNoteResult> getDelNote(ReNoteParam param) {
		return renoteDao.getDelNote(param);
	}
	
	/**
	 *还原笔记
	 * 
	 * @param renote 要还原的笔记
	 * @return
	 */
	public int reNote(ReNote note) {
		return renoteDao.reNote(note);
	}
	
	/**
	 * 删除笔记
	 * 
	 * @param note 要删除的笔记
	 * @return
	 */
	public int deleteNote(ReNote note) {
		return renoteDao.deleteNote(note);
	}

}
