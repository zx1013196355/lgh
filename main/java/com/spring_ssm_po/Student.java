package com.spring_ssm_po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_ssm_valitation.ValidGroup1;
import com.spring_ssm_valitation.ValidGroup2;

import javax.validation.constraints.Size;

public class Student {
    @JsonProperty(value="pic")//指定传json到前端时的key
    private String pic;
    @JsonProperty(value="id")
    private int id;
    @JsonProperty(value="name1")

    @Size(min = 1, max = 20, message = "{validation_Student_name1_error}",groups = {ValidGroup1.class, ValidGroup2.class})
    private String name1;
    @JsonProperty(value="tid")
    private int tid;
    @Size(min = 1, message = "{validation_Student_address_error}")
    @JsonProperty(value="address")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
