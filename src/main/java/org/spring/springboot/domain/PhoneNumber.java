package org.spring.springboot.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuxiaowei on 2018/1/10
 */

@Document(indexName = "resource", type = "PhoneNumber")
public class PhoneNumber implements Serializable {

    private Long id;

    private Long phone_number_id;

    private String phone_number;

    private Long pn_type_id;

    private Long province_id;

    private Long area_id;

    private Long pool_id;

    private Long pn_level_id;

    private String status_cd;

    private Long pn_character_id;

    private Long reseller_id;

    private Date create_date;

    private Date upDate_date;

    private String description;

    private String with_nbr;

    private String goodNum_flag;

    private Long appRove_id;

    private Long pre_store_price;

    private Long pn_low_price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone_number_id() {
        return phone_number_id;
    }

    public void setPhone_number_id(Long phone_number_id) {
        this.phone_number_id = phone_number_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getPn_type_id() {
        return pn_type_id;
    }

    public void setPn_type_id(Long pn_type_id) {
        this.pn_type_id = pn_type_id;
    }

    public Long getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Long province_id) {
        this.province_id = province_id;
    }

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }

    public Long getPool_id() {
        return pool_id;
    }

    public void setPool_id(Long pool_id) {
        this.pool_id = pool_id;
    }

    public Long getPn_level_id() {
        return pn_level_id;
    }

    public void setPn_level_id(Long pn_level_id) {
        this.pn_level_id = pn_level_id;
    }

    public String getStatus_cd() {
        return status_cd;
    }

    public void setStatus_cd(String status_cd) {
        this.status_cd = status_cd;
    }

    public Long getPn_character_id() {
        return pn_character_id;
    }

    public void setPn_character_id(Long pn_character_id) {
        this.pn_character_id = pn_character_id;
    }

    public Long getReseller_id() {
        return reseller_id;
    }

    public void setReseller_id(Long reseller_id) {
        this.reseller_id = reseller_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpDate_date() {
        return upDate_date;
    }

    public void setUpDate_date(Date upDate_date) {
        this.upDate_date = upDate_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWith_nbr() {
        return with_nbr;
    }

    public void setWith_nbr(String with_nbr) {
        this.with_nbr = with_nbr;
    }

    public String getGoodNum_flag() {
        return goodNum_flag;
    }

    public void setGoodNum_flag(String goodNum_flag) {
        this.goodNum_flag = goodNum_flag;
    }

    public Long getAppRove_id() {
        return appRove_id;
    }

    public void setAppRove_id(Long appRove_id) {
        this.appRove_id = appRove_id;
    }

    public Long getPre_store_price() {
        return pre_store_price;
    }

    public void setPre_store_price(Long pre_store_price) {
        this.pre_store_price = pre_store_price;
    }

    public Long getPn_low_price() {
        return pn_low_price;
    }

    public void setPn_low_price(Long pn_low_price) {
        this.pn_low_price = pn_low_price;
    }


    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", phone_number_id=" + phone_number_id +
                ", phone_number='" + phone_number + '\'' +
                ", pn_type_id=" + pn_type_id +
                ", province_id=" + province_id +
                ", area_id=" + area_id +
                ", pool_id=" + pool_id +
                ", pn_level_id=" + pn_level_id +
                ", status_cd='" + status_cd + '\'' +
                ", pn_character_id=" + pn_character_id +
                ", reseller_id=" + reseller_id +
                ", create_date=" + create_date +
                ", upDate_date=" + upDate_date +
                ", description='" + description + '\'' +
                ", with_nbr='" + with_nbr + '\'' +
                ", goodNum_flag='" + goodNum_flag + '\'' +
                ", appRove_id=" + appRove_id +
                ", pre_store_price=" + pre_store_price +
                ", pn_low_price=" + pn_low_price +
                '}';
    }
}
