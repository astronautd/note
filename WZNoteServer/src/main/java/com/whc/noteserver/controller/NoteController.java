package com.whc.noteserver.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.noteserver.entity.Note;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.util.JsonResult;

@Controller // 注解，组件扫描加入到spring容器中
@RequestMapping("/note") // 类controller的映射路径
public class NoteController {

	@Autowired
	NoteService noteService;

	/**
	 * 获取笔记信息
	 * 
	 * @return
	 */
	@RequestMapping("/getnote")
	@ResponseBody
	public JsonResult getNote(NoteParam param) {

		param.setPage((param.getPage() - 1) * param.getLimit());
		// System.out.println("page:"+page+" limit:"+limit);
		List<NoteResult> list = noteService.getNote(param);
		int count = noteService.getCount(param);
		// 构建一个对象
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);

		return new JsonResult(JsonResult.STATE_SUCCESS, "", lp);
	}

	/**
	 * 添加笔记
	 * 
	 * @return
	 */
	@RequestMapping("/addnote")
	@ResponseBody
	public JsonResult addNote(Note note) {

		note.setId(UUID.randomUUID().toString());
		note.setAddtime(System.currentTimeMillis());
		note.setIsdelete(0);
		// note.setUserid();
		int result = noteService.addNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "添加成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "添加失败", null);
		}
	}

	/**
	 * 获取单个笔记信息
	 * 
	 * @return
	 */
	@RequestMapping("/getdetail")
	@ResponseBody
	public JsonResult getNoteDetail(Note note) {
		List<Note> list = noteService.getNoteDetail(note);
		if (list != null && !list.isEmpty()) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "", list.get(0));
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "未查询到笔记", null);
		}

	}

	/**
	 * 修改笔记
	 * 
	 * @return
	 */
	@RequestMapping("/updatenote")
	@ResponseBody
	public JsonResult updateNote(Note note) {
		int result = noteService.updateNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "修改成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "修改失败", null);
		}
	}

	/**
	 * 删除笔记
	 * 
	 * @return
	 */
	@RequestMapping("/deletenote")
	@ResponseBody
	public JsonResult deleteNote(Note note) {
		int result = noteService.deleteNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "删除成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "删除失败", null);
		}
	}

}
