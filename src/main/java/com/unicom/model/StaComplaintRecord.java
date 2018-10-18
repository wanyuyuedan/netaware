package com.unicom.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 投诉信息登记
 */
public class StaComplaintRecord implements java.io.Serializable {

    private String complaintNum;//工单流水号
    private String downType ;//故障类型
    private String downAppear;//故障现象
    private String mobileNum;//手机号码
    private String complaintAddress;//投诉地址
    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;//登记时间
    private String netType;//网络类型
    private Integer isRecovery;//恢复与否（0,1）
    private String lng;//经度
    private String lac;//纬度
    private String bigX;//X坐标
    private String bigY;//Y坐标
    private String userEmotion;//用户情绪
    private StaArea staArea;//小区编码
    private String reserved1;//预留1
    private String reserved2;//预留1

    public String getComplaintNum() {
        return complaintNum;
    }

    public void setComplaintNum(String complaintNum) {
        this.complaintNum = complaintNum;
    }

    public String getDownType() {
        return downType;
    }

    public void setDownType(String downType) {
        this.downType = downType;
    }

    public String getDownAppear() {
        return downAppear;
    }

    public void setDownAppear(String downAppear) {
        this.downAppear = downAppear;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getComplaintAddress() {
        return complaintAddress;
    }

    public void setComplaintAddress(String complaintAddress) {
        this.complaintAddress = complaintAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public Integer getIsRecovery() {
        return isRecovery;
    }

    public void setIsRecovery(Integer isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getBigX() {
        return bigX;
    }

    public void setBigX(String bigX) {
        this.bigX = bigX;
    }

    public String getBigY() {
        return bigY;
    }

    public void setBigY(String bigY) {
        this.bigY = bigY;
    }

    public String getUserEmotion() {
        return userEmotion;
    }

    public void setUserEmotion(String userEmotion) {
        this.userEmotion = userEmotion;
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
        return "StaComplaintRecord{" +
                "complaintNum='" + complaintNum + '\'' +
                ", downType='" + downType + '\'' +
                ", downAppear='" + downAppear + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", complaintAddress='" + complaintAddress + '\'' +
                ", createTime=" + createTime +
                ", netType='" + netType + '\'' +
                ", isRecovery=" + isRecovery +
                ", lng='" + lng + '\'' +
                ", lac='" + lac + '\'' +
                ", bigX='" + bigX + '\'' +
                ", bigY='" + bigY + '\'' +
                ", userEmotion=" + userEmotion +
                ", staArea=" + staArea +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                '}';
    }
}
