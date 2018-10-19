package com.unicom.service.impl;

import com.github.pagehelper.PageHelper;
import com.unicom.mapper.StaComplaintRecordMapper;
import com.unicom.model.Pager;
import com.unicom.model.StaArea;
import com.unicom.model.StaComplaintRecord;
import com.unicom.service.StaComplaintRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaComplaintRecordServiceImpl implements StaComplaintRecordService {

    @Autowired
    private StaComplaintRecordMapper mapper;

    @Override
    public StaComplaintRecord getById(String complaintNum) {
        return mapper.getById(complaintNum);
    }

    @Override
    public List<StaComplaintRecord> getAll(StaComplaintRecord record,Pager pager)
    {
        PageHelper.startPage(pager.getPage(), pager.getRows());
        return mapper.getAll(record);
    }

    @Override
    public int countAll(StaComplaintRecord record) {
        return mapper.countAll(record);
    }

    @Override
    public void add(StaComplaintRecord record) {
        mapper.add(record);
    }

    @Override
    public void update(StaComplaintRecord record) {
        mapper.update(record);
    }

    @Override
    public void delete(String complaintNum) {
        mapper.delete(complaintNum);
    }

}
