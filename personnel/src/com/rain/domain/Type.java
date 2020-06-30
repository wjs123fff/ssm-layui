package com.rain.domain;

import java.io.Serializable;

public class Type implements Serializable{
    public Integer getId() {
        return type_id;
    }

    public void setId(Integer type_id) {
        this.type_id = type_id;
    }

    private Integer type_id;
    private String name;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type(){
        super();
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
