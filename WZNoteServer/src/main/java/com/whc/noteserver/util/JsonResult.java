package com.whc.noteserver.util;

import java.io.Serializable;

public class JsonResult implements Serializable {

	private static final long serialVersionUID = -992471179944021785L;
	public static String STATE_SUCCESS = "1";
	public static String STATE_ERROR = "-1";
	private String state;// 返回状态
	private String message;// 返回消息
	private Object data;// 返回数据

	public JsonResult() {

	}

	public JsonResult(String state, String message, Object data) {
		this.state = state;
		this.message = message;
		this.data = data;

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
