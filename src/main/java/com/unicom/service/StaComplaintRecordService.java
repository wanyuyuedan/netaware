package com.unicom.service;

import com.unicom.model.Pager;
import com.unicom.model.StaArea;
import com.unicom.model.StaComplaintRecord;

import java.util.List;

/**
 * 投诉信息查询service
 * zhengyangbo
 */
public interface StaComplaintRecordService {

    /**
     * 根据编号查询
     * @param complaintNum
     * @return
     */
    StaComplaintRecord getById(String complaintNum);

    /**
     * 查询所有
     * @param record
     * @return
     */
    List<StaComplaintRecord> getAll(StaComplaintRecord record,Pager pager);

    /**
     * 统计条数
     * @param record
     * @return
     */
    int countAll(StaComplaintRecord record);

    /**
     * 添加
     * @param record
     * @return
     */
    void add(StaComplaintRecord record);

    /**
     * 修改
     * @param record
     */
    void update(StaComplaintRecord record);

    /**
     * 删除
     * @param complaintNum
     */
    void delete(String complaintNum);

}
