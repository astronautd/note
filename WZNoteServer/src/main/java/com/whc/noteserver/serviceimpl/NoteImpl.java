package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteDao;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.service.NoteService;

@Service
public class NoteImpl implements NoteService {
	
	@Autowired
	NoteDao noteDao;
	
	public List<NoteResult> getNoteForeach(List<String> id){
		return noteDao.getNoteForeach(id);
	}

	public int getCount(NoteParam param) {
		return noteDao.getCount(param);
	}

	/**
	 * 获取笔记信息
	 * 
	 * @return
	 */
	public List<NoteResult> getNote(NoteParam param) {
		return noteDao.getNote(param);
	}

	/**
	 * 添加笔记信息
	 * 
	 * @param note 要添加的笔记
	 * @return
	 */
	public int addNote(Note note) {
		return noteDao.addNote(note);
	}

	/**
	 * 查询单个笔记信息
	 * 
	 * @param note 根据note的id
	 * @return
	 */
	public List<Note> getNoteDetail(Note note) {
		return noteDao.getNoteDetail(note);
	}

	/**
	 * 更新笔记信息
	 * 
	 * @param note 要更新的笔记
	 * @return
	 */
	public int updateNote(Note note) {
		return noteDao.updateNote(note);
	}

	/**
	 * 删除笔记
	 * 
	 * @param note 要删除的笔记
	 * @return
	 */
	public int deleteNote(Note note) {
		return noteDao.deleteNote(note);
	}

}
