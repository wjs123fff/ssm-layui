package com.rain.domain;

import java.io.Serializable;

public class Job implements Serializable{
	public Integer getId() {
		return job_id;
	}

	public void setId(Integer job_id) {
		this.job_id = job_id;
	}

	private Integer job_id;
	private String name;
	private String remark;
	public Job(){
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
