package com.unicom.service;

import com.unicom.model.Pager;
import com.unicom.model.StaArea;

import java.util.List;

/**
 * 小区信息查询service
 * zhengyangbo
 */
public interface StaAreaService {

    /**
     * 根据areaId查询
     * @param areaId
     * @return
     */
    StaArea getByAreaId(String areaId);

    /**
     * 查询所有
     * @param staArea
     * @return
     */
    List<StaArea> getAll(StaArea staArea,Pager pager);

    /**
     * 统计条数
     * @param staArea
     * @return
     */
    int countAll(StaArea staArea);

    /**
     * 添加
     * @param staArea
     * @return
     */
    void add(StaArea staArea);

    /**
     * 修改
     * @param staArea
     */
    void update(StaArea staArea);

    /**
     * 删除
     * @param areaId
     */
    void delete(String areaId);

}
