package com.unicom.controller;

import com.unicom.model.*;
import com.unicom.service.StaComplaintRecordService;
import com.unicom.utils.AppUtil;
import com.unicom.utils.Location;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value="断站信息管理接口")
@RequestMapping("/staComplaintRecord")
public class StaComplaintRecordController extends BaseController {

    @Autowired
    private StaComplaintRecordService service;

    private Location location;

    /**
     * 通过complaintNum查询
     * @param complaintNum
     * @param req
     * @return
     */
    @RequestMapping("/get")
    @ApiOperation(value="单条记录查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "complaintNum", value = "投诉编号", required = true, dataType = "String")
    public Json queryBycomplaintNum(String complaintNum, HttpServletRequest req){
        if(complaintNum == null || "".equals(complaintNum)){
            return new ErrorJson("投诉编号不能为空！");
        }
        StaComplaintRecord area = service.getById(complaintNum);
        if(area!=null){
            return new SuccessJson("查询成功!",area);
        }else{
            return new ErrorJson("查询失败，找不到任何记录！");
        }
    }

    @RequestMapping("/getAll")
    @ApiOperation(value="批量查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "complaintNum", value = "投诉编号", required = true, dataType = "String")
    public PageData queryBycomplaintNum(StaComplaintRecord record, Pager pager, HttpServletRequest req){

        List<StaComplaintRecord> list = service.getAll(record,pager);
        int total = service.countAll(record);
        PageData pageData = new PageData(list,total);
        return pageData;
    }

    @RequestMapping("/add")
    @Transactional
    @ApiOperation(value="投诉信息添加接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json add(StaComplaintRecord record, HttpServletRequest req){
        if(record == null){
            return new ErrorJson("投诉编号和投诉编码不能为空！");
        }
        System.out.printf(record.toString());
        if(record.getComplaintNum()==null||"".equals(record.getComplaintNum())){
            String id = AppUtil.getNowTime();
            record.setComplaintNum(id);
        }

        double x,y;
        if(record.getLng()!=null && record.getLac() !=null){
            x = Double.parseDouble(record.getLng());
            y = Double.parseDouble(record.getLac());
            String areaId = location.getArea(x,y);
            StaArea staArea = new StaArea();
            staArea.setAreaId(areaId);
            record.setStaArea(staArea);
        }
        if(record.getStaArea()!=null){
            System.out.printf("--staArea--");
            System.out.printf(record.getStaArea().toString());
        }

        service.add(record);
        return new SuccessJson("添加成功!",record);

    }

    @RequestMapping("/update")
    @Transactional
    @ApiOperation(value="投诉信息编辑接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json update(StaComplaintRecord record, HttpServletRequest req){
        if(record == null){
            return new ErrorJson("参数不能为空！");
        }
        StaComplaintRecord area = service.getById(record.getComplaintNum());
        if(area!=null){
            service.update(record);
            return new SuccessJson("编辑成功!",record);
        }else{
            return new ErrorJson("编辑失败，不存在该条记录！");
        }
    }

    @RequestMapping("/delete")
    @Transactional
    @ApiOperation(value="投诉信息删除接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json delete(String complaintNum, HttpServletRequest req){
        if(complaintNum == null || "".equals(complaintNum) ){
            return new ErrorJson("投诉编号不能为空！");
        }
        StaComplaintRecord area = service.getById(complaintNum);
        if(area!=null){
            service.delete(complaintNum);
            return new SuccessJson("删除成功!",area);
        }else{
            return new ErrorJson("删除失败，不存在该条记录！");
        }
    }
}
