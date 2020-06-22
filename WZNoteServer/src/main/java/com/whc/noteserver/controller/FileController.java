package com.whc.noteserver.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.param.NoteBookParam;
import com.whc.noteserver.result.LayPage;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.util.JsonResult;


@Controller //注解，组件扫描加入到spring容器中
@RequestMapping("/file") //类controller的映射路径
public class FileController {
	
	
	/**
	 *  文件上传
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public JsonResult upload(MultipartFile file) {
		try {
			String path="E:\\images\\2020-06-17\\";
			if(!new File(path).exists()) {
				new File(path).mkdirs();
			}
			String fileName="1.xls";
			
			file.transferTo(new File(path+fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new JsonResult(JsonResult.STATE_SUCCESS,"上传成功",null);
		
		
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response) {
		String filePath="E:\\images\\2020-06-17\\1.xls";
		try {
			InputStream bis= new BufferedInputStream(new FileInputStream(new File(filePath)));
			String fileName="张三.xls";
			fileName=URLEncoder.encode(fileName,"UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename="+fileName);
			response.setContentType("multipart/form-data");
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int len=0;
			while((len=bis.read())!=-1) {
				out.write(len);
				out.flush();
			}
			out.close();
			bis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
