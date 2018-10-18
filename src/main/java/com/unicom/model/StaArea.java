package com.unicom.model;

/**
 * 小区信息实体
 * zhengyangbo
 */
public class StaArea implements java.io.Serializable {

    private String areaId;//小区编码
    private String areaName;//小区名称
    private String reserved1;//预留1
    private String reserved2;//预留1

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
        return "StaArea{" +
                "areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2='" + reserved2 + '\'' +
                '}';
    }
}
