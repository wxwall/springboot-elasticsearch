package org.spring.springboot.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Created by wuxiaowei on 2018/1/11
 */

@Document(indexName = "resource", type = "PhoneNbrLevel")
public class PhoneNbrLevel {

    private Long id;

    private Long pn_Level_Id;

    private String pn_Level_Cd;

    private String pn_Level_Name;

    private Date create_Date;

    private Date update_Date;

    private Long staff_Id;

    private String desc_Msg;

    private Long area_Id;

    private String approve_No;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPn_Level_Id() {
        return pn_Level_Id;
    }

    /**
     * 将pn_Level_Id赋值给id，es需要id为主健
     * @param pn_Level_Id
     */
    public void setPn_Level_Id(Long pn_Level_Id) {
        if(id==null){
            this.id = pn_Level_Id;
        }
        this.pn_Level_Id = pn_Level_Id;
    }

    public String getPn_Level_Cd() {
        return pn_Level_Cd;
    }

    public void setPn_Level_Cd(String pn_Level_Cd) {
        this.pn_Level_Cd = pn_Level_Cd;
    }

    public String getPn_Level_Name() {
        return pn_Level_Name;
    }

    public void setPn_Level_Name(String pn_Level_Name) {
        this.pn_Level_Name = pn_Level_Name;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Long getStaff_Id() {
        return staff_Id;
    }

    public void setStaff_Id(Long staff_Id) {
        this.staff_Id = staff_Id;
    }

    public String getDesc_Msg() {
        return desc_Msg;
    }

    public void setDesc_Msg(String desc_Msg) {
        this.desc_Msg = desc_Msg;
    }

    public Long getArea_Id() {
        return area_Id;
    }

    public void setArea_Id(Long area_Id) {
        this.area_Id = area_Id;
    }

    public String getApprove_No() {
        return approve_No;
    }

    public void setApprove_No(String approve_No) {
        this.approve_No = approve_No;
    }

    @Override
    public String toString() {
        return "PhoneNbrLevel{" +
                "id=" + id +
                ", pn_Level_Id=" + pn_Level_Id +
                ", pn_Level_Cd='" + pn_Level_Cd + '\'' +
                ", pn_Level_Name='" + pn_Level_Name + '\'' +
                ", create_Date=" + create_Date +
                ", update_Date=" + update_Date +
                ", staff_Id=" + staff_Id +
                ", desc_Msg='" + desc_Msg + '\'' +
                ", area_Id=" + area_Id +
                ", approve_No='" + approve_No + '\'' +
                '}';
    }
}
