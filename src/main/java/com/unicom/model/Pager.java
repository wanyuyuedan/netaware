package com.unicom.model;

import java.io.Serializable;

public class Pager implements Serializable {
	
	private Integer page=1;
	private Integer rows=10;
	
	public Pager() {
		
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Pager{" +
				"page=" + page +
				", rows=" + rows +
				'}';
	}
}
