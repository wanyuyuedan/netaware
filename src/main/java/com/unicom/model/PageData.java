package com.unicom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageData implements Serializable {
 
	private static final long serialVersionUID = 1L;
	//数据
	private List  data = new ArrayList();
	//总记录数
	private Integer total=0;
	
	public PageData() {
		
	}
	public PageData(List data, Integer total) {
		this.data = data;
		this.total = total;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	

}
