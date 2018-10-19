package com.unicom.service.impl;

import com.github.pagehelper.PageHelper;
import com.unicom.mapper.StaBrokenRecordMapper;
import com.unicom.model.Pager;
import com.unicom.model.StaBrokenRecord;
import com.unicom.service.StaBrokenRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaBrokenRecordServiceImpl implements StaBrokenRecordService {

    @Autowired
    private StaBrokenRecordMapper mapper;

    @Override
    public StaBrokenRecord getById(String brokenNum) {
        return mapper.getById(brokenNum);
    }

    @Override
    public List<StaBrokenRecord> getAll(StaBrokenRecord record,Pager pager) {
        PageHelper.startPage(pager.getPage(), pager.getRows());
        return mapper.getAll(record);
    }

    @Override
    public int countAll(StaBrokenRecord record) {
        return mapper.countAll(record);
    }

    @Override
    public void add(StaBrokenRecord record) {
        mapper.add(record);
    }

    @Override
    public void update(StaBrokenRecord record) {
        mapper.update(record);
    }

    @Override
    public void delete(String brokenNum) {
        mapper.delete(brokenNum);
    }
}
