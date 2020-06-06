package com.whc.noteserver.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.NoteBookDao;
import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.service.NoteBookService;

@Service
public class NoteBookImpl implements NoteBookService {

	@Autowired
	NoteBookDao noteBookDao;

	public int getCount(NoteBookParam param) {
		return noteBookDao.getCount(param);
	}

	/**
	 * 获取笔记本信息
	 * 
	 * @return
	 */
	public List<NoteBook> getNoteBook(NoteBookParam param) {
		return noteBookDao.getNoteBook(param);
	}

	/**
	 * 添加笔记本信息
	 * 
	 * @param noteBook 要添加的笔记本
	 * @return
	 */
	public int addNoteBook(NoteBook noteBook) {
		return noteBookDao.addNoteBook(noteBook);
	}

	/**
	 * 查询单个笔记本信息
	 * 
	 * @param noteBook 根据noteBook的id
	 * @return
	 */
	public List<NoteBook> getNoteBookDetail(NoteBook noteBook) {
		return noteBookDao.getNoteBookDetail(noteBook);
	}

	/**
	 * 更新笔记本信息
	 * 
	 * @param noteBook 要更新的笔记本
	 * @return
	 */
	public int updateNoteBook(NoteBook noteBook) {
		return noteBookDao.updateNoteBook(noteBook);
	}

	/**
	 * 删除笔记本
	 * 
	 * @param noteBook 要删除的笔记本
	 * @return
	 */
	public int deleteNoteBook(NoteBook noteBook) {
		return noteBookDao.deleteNoteBook(noteBook);
	}

	/**
	 * 根据用户id获取所有笔记本信息
	 * 
	 * @param param
	 * @return
	 */
	public List<NoteBook> getAllNoteBookByUserId(NoteBookParam param) {
		return noteBookDao.getAllNoteBookByUserId(param);
	}

}
