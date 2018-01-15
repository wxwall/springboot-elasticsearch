package org.spring.springboot.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * 号码属性
 * Created by wuxiaowei on 2018/1/11
 */
@Document(indexName = "resource", type = "PhoneNumberAttr")
public class PhoneNumberAttr {

    private Long id;

    private Long phone_number_id;

    private String attr_spec_id;

    private Date create_date;

    private Date update_date;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone_number_id() {
        return phone_number_id;
    }

    //es中必须以ID为主健，这里将phone_number_id直接等于id
    public void setPhone_number_id(Long phone_number_id) {
        if(id == null){
            this.id = phone_number_id;
        }
        this.phone_number_id = phone_number_id;
    }

    public String getAttr_spec_id() {
        return attr_spec_id;
    }

    public void setAttr_spec_id(String attr_spec_id) {
        this.attr_spec_id = attr_spec_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "PhoneNumberAttr{" +
                "id=" + id +
                ", phone_number_id=" + phone_number_id +
                ", attr_spec_id='" + attr_spec_id + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
