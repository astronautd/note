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
import com.whc.noteserver.entity.ReNote;
import com.whc.noteserver.param.NoteParam;
import com.whc.noteserver.param.ReNoteParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.result.NoteResult;
import com.whc.noteserver.result.DelNoteResult;
import com.whc.noteserver.service.NoteService;
import com.whc.noteserver.service.ReNoteService;
import com.whc.noteserver.util.JsonResult;

@Controller // 注解，组件扫描加入到spring容器中
@RequestMapping("/renote") // 类controller的映射路径
public class ReNoteController {

	@Autowired
	ReNoteService renoteService;

	/**
	 * 获取删除的笔记信息
	 * 
	 * @return
	 */
	@RequestMapping("/getdelnote")
	@ResponseBody
	public JsonResult getDelNote(ReNoteParam param) {

		param.setPage((param.getPage() - 1) * param.getLimit());
		// System.out.println("page:"+page+" limit:"+limit);
		List<DelNoteResult> list = renoteService.getDelNote(param);
		int count = renoteService.getCount(param);
		// 构建一个对象
		LayPage lp = new LayPage();
		lp.setCount(count);
		lp.setList(list);

		return new JsonResult(JsonResult.STATE_SUCCESS, "", lp);
	}

	/**
	 * 还原笔记
	 * 
	 * @return
	 */
	@RequestMapping("/renote")
	@ResponseBody
	public JsonResult renote(ReNote note) {
		int result = renoteService.reNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "还原成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "还原失败", null);
		}
	}

	/**
	 * 彻底删除笔记
	 * 
	 * @return
	 */
	@RequestMapping("/deletenote")
	@ResponseBody
	public JsonResult deleteNote(ReNote note) {
		int result = renoteService.deleteNote(note);
		if (result == 1) {
			return new JsonResult(JsonResult.STATE_SUCCESS, "删除成功", null);
		} else {
			return new JsonResult(JsonResult.STATE_ERROR, "删除失败", null);
		}
	}

}
