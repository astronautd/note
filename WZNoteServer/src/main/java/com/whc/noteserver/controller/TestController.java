package com.whc.noteserver.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whc.noteserver.entity.NoteBook;
import com.whc.noteserver.service.NoteBookService;
import com.whc.noteserver.util.JsonResult;

@Controller // ע�⣬���ɨ����뵽spring������
@RequestMapping("/demo") // ��controller��ӳ��·��
public class TestController {
	
	@RequestMapping("/table")
	@ResponseBody
	public String getNoteBook() {
		return "{\"code\":0,\"msg\":\"\",\"count\":1000,\"data\":[{\"id\":10000,\"username\":\"user-0\",\"sex\":\"Ů\",\"city\":\"����-0\",\"sign\":\"ǩ��-0\",\"experience\":255,\"logins\":24,\"wealth\":82830700,\"classify\":\"����\",\"score\":57},{\"id\":10001,\"username\":\"user-1\",\"sex\":\"��\",\"city\":\"����-1\",\"sign\":\"ǩ��-1\",\"experience\":884,\"logins\":58,\"wealth\":64928690,\"classify\":\"����\",\"score\":27},{\"id\":10002,\"username\":\"user-2\",\"sex\":\"Ů\",\"city\":\"����-2\",\"sign\":\"ǩ��-2\",\"experience\":650,\"logins\":77,\"wealth\":6298078,\"classify\":\"����\",\"score\":31},{\"id\":10003,\"username\":\"user-3\",\"sex\":\"Ů\",\"city\":\"����-3\",\"sign\":\"ǩ��-3\",\"experience\":362,\"logins\":157,\"wealth\":37117017,\"classify\":\"ʫ��\",\"score\":68},{\"id\":10004,\"username\":\"user-4\",\"sex\":\"��\",\"city\":\"����-4\",\"sign\":\"ǩ��-4\",\"experience\":807,\"logins\":51,\"wealth\":76263262,\"classify\":\"����\",\"score\":6},{\"id\":10005,\"username\":\"user-5\",\"sex\":\"Ů\",\"city\":\"����-5\",\"sign\":\"ǩ��-5\",\"experience\":173,\"logins\":68,\"wealth\":60344147,\"classify\":\"����\",\"score\":87},{\"id\":10006,\"username\":\"user-6\",\"sex\":\"Ů\",\"city\":\"����-6\",\"sign\":\"ǩ��-6\",\"experience\":982,\"logins\":37,\"wealth\":57768166,\"classify\":\"����\",\"score\":34},{\"id\":10007,\"username\":\"user-7\",\"sex\":\"��\",\"city\":\"����-7\",\"sign\":\"ǩ��-7\",\"experience\":727,\"logins\":150,\"wealth\":82030578,\"classify\":\"����\",\"score\":28},{\"id\":10008,\"username\":\"user-8\",\"sex\":\"��\",\"city\":\"����-8\",\"sign\":\"ǩ��-8\",\"experience\":951,\"logins\":133,\"wealth\":16503371,\"classify\":\"����\",\"score\":14},{\"id\":10009,\"username\":\"user-9\",\"sex\":\"Ů\",\"city\":\"����-9\",\"sign\":\"ǩ��-9\",\"experience\":484,\"logins\":25,\"wealth\":86801934,\"classify\":\"����\",\"score\":75}]}";
	}

}