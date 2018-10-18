package com.unicom.service.impl;

import com.github.pagehelper.PageHelper;
import com.unicom.mapper.StaAreaMapper;
import com.unicom.model.Pager;
import com.unicom.model.StaArea;
import com.unicom.service.StaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaAreaServiceImpl implements StaAreaService {

    @Autowired
    private StaAreaMapper mapper;

    @Override
    public StaArea getByAreaId(String areaId) {
        return mapper.getByAreaId(areaId);
    }

    @Override
    public List<StaArea> getAll(StaArea staArea,Pager pager) {
        PageHelper.startPage(pager.getPage(), pager.getRows());
        return mapper.getAll(staArea);
    }

    @Override
    public int countAll(StaArea staArea) {
        return mapper.countAll(staArea);
    }

    @Override
    public void add(StaArea staArea) {
        mapper.add(staArea);
    }

    @Override
    public void update(StaArea staArea) {
        mapper.update(staArea);
    }

    @Override
    public void delete(String areaId) {
        mapper.delete(areaId);
    }
}
