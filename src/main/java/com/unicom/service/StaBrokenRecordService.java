package com.unicom.service;

import com.unicom.model.Pager;
import com.unicom.model.StaBrokenRecord;

import java.util.List;

/**
 * 断站信息查询service
 * zhengyangbo
 */
public interface StaBrokenRecordService {

    /**
     * 根据areaId查询
     * @param brokenNum
     * @return
     */
    StaBrokenRecord getById(String brokenNum);

    /**
     * 查询所有
     * @param record
     * @return
     */
    List<StaBrokenRecord> getAll(StaBrokenRecord record,Pager pager);

    /**
     * 统计条数
     * @param record
     * @return
     */
    int countAll(StaBrokenRecord record);

    /**
     * 添加
     * @param record
     * @return
     */
    void add(StaBrokenRecord record);

    /**
     * 修改
     * @param record
     */
    void update(StaBrokenRecord record);

    /**
     * 删除
     * @param brokenNum
     */
    void delete(String brokenNum);

}
