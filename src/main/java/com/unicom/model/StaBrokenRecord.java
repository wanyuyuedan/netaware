package com.unicom.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 断站信息实体
 * zhengyangbo
 */
public class StaBrokenRecord implements java.io.Serializable {

    private String brokenNum;//故障流水号
    private String staId;//基站编码
    private String isrecovery;//是否恢复
    private String brokenType;//故障类型
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date brokenTime;//故障时间
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date recoverTime;//恢复时间
    private String brokenReason;//故障原因
    private Integer brokenAddress;//故障位置
    private StaArea staArea;//小区编码
    private String reserved1;//预留1
    private String reserved2;//预留1

    public String getBrokenNum() {
        return brokenNum;
    }

    public void setBrokenNum(String brokenNum) {
        this.brokenNum = brokenNum;
    }

    public String getStaId() {
        return staId;
    }

    public void setStaId(String staId) {
        this.staId = staId;
    }

    public String getIsrecovery() {
        return isrecovery;
    }

    public void setIsrecovery(String isrecovery) {
        this.isrecovery = isrecovery;
    }

    public String getBrokenType() {
        return brokenType;
    }

    public void setBrokenType(String brokenType) {
        this.brokenType = brokenType;
    }

    public Date getBrokenTime() {
        return brokenTime;
    }

    public void setBrokenTime(Date brokenTime) {
        this.brokenTime = brokenTime;
    }

    public Date getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(Date recoverTime) {
        this.recoverTime = recoverTime;
    }

    public String getBrokenReason() {
        return brokenReason;
    }

    public void setBrokenReason(String brokenReason) {
        this.brokenReason = brokenReason;
    }

    public Integer getBrokenAddress() {
        return brokenAddress;
    }

    public void setBrokenAddress(Integer brokenAddress) {
        this.brokenAddress = brokenAddress;
    }

    public StaArea getStaArea() {
        return staArea;
    }

    public void setStaArea(StaArea staArea) {
        this.staArea = staArea;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    @Override
    public String toString() {
        return "StaBrokenRecord{" +
                "brokenNum='" + brokenNum + '\'' +
                ", staId='" + staId + '\'' +
                ", isrecovery='" + isrecovery + '\'' +
                ", brokenType='" + brokenType + '\'' +
                ", brokenTime=" + brokenTime +
                ", recoverTime=" + recoverTime +
                ", brokenReason='" + brokenReason + '\'' +
                ", brokenAddress=" + brokenAddress +
                ", staArea=" + staArea +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                '}';
    }
}
