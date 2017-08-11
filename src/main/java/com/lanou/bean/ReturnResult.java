package com.lanou.bean;

public class ReturnResult {
	private String str;
	private String  error;
	private Object objiect;
	
	public static ReturnResult giveHtml(String str, String error, Object objiect){
		
		ReturnResult r=new ReturnResult();
	r.setStr( str);
	r.setError(error);
	r.setObjiect(objiect);
	return r;

	}
	
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getObjiect() {
		return objiect;
	}
	public void setObjiect(Object objiect) {
		this.objiect = objiect;
	}
	

}
