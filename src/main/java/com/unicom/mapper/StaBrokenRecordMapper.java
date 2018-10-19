package com.unicom.mapper;

import com.unicom.model.StaArea;
import com.unicom.model.StaBrokenRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 断站信息查询mappper
 * zhengyangbo
 */
public interface StaBrokenRecordMapper {

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
    List<StaBrokenRecord> getAll(StaBrokenRecord record);

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
    void add(@Param("record")StaBrokenRecord record);

    /**
     * 修改
     * @param record
     */
    void update(@Param("record")StaBrokenRecord record);

    /**
     * 删除
     * @param brokenNum
     */
    void delete(String brokenNum);

}
