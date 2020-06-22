package com.whc.noteserver.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.whc.noteserver.dao.JFDao;
import com.whc.noteserver.entity.JF;

public class JFImpl {
	
	@Autowired
	JFDao jfDao;
	public int addJF(JF jf) {
		
		return jfDao.addJF(jf);
	};

}
