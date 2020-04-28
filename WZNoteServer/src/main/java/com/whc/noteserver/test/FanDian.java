package com.whc.noteserver.test;

import org.springframework.stereotype.Component;

@Component
public class FanDian {
	private String fanDianName;
	public void say() {
		System.out.println(fanDianName);
		System.out.println("我可以做饭，小米粥、油条");
	}
	public void setFanDianname(String fanDianName) {
		this.fanDianName = fanDianName;
	}
	
	

}