package com.whc.noteserver.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String personName;

	/*
	 * public void setFanDian(FanDian fanDian) { this.fanDian = fanDian; }
	 */

	public void setPersonname(String personName) {
		this.personName = personName;
	}

	public void say() {
		System.out.println(personName);
		System.out.println("ÎÒÒªµã²Ë");
		// fanDian.say();
	}
}
