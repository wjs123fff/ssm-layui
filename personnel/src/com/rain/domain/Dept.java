package com.rain.domain;

import java.io.Serializable;

public class Dept implements Serializable{
	public Integer getId() {
		return dept_id;
	}

	public void setId(Integer dept_id) {
		this.dept_id = dept_id;
	}

	private Integer dept_id;
	private String name;
	private String remark;
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Dept(){
		super();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
