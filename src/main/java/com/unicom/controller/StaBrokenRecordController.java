package com.unicom.controller;

import com.unicom.model.*;
import com.unicom.service.StaAreaService;
import com.unicom.service.StaBrokenRecordService;
import com.unicom.utils.AppUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@Api(value="断站信息管理接口")
@RequestMapping("/staBrokenRecord")
public class StaBrokenRecordController extends BaseController {

    @Autowired
    private StaBrokenRecordService service;

    /**
     * 通过brokenNum查询
     * @param brokenNum
     * @param req
     * @return
     */
    @RequestMapping("/get")
    @ApiOperation(value="单条记录查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "brokenNum", value = "断站编号", required = true, dataType = "String")
    public Json queryBybrokenNum(String brokenNum, HttpServletRequest req){
        if(brokenNum == null || "".equals(brokenNum)){
            return new ErrorJson("断站编号不能为空！");
        }
        StaBrokenRecord area = service.getById(brokenNum);
        if(area!=null){
            return new SuccessJson("查询成功!",area);
        }else{
            return new ErrorJson("查询失败，找不到任何记录！");
        }
    }

    @RequestMapping("/getAll")
    @ApiOperation(value="批量查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "brokenNum", value = "断站编号", required = true, dataType = "String")
    public PageData queryBybrokenNum(StaBrokenRecord record,Pager pager, HttpServletRequest req){
        System.out.printf(record!=null?record.toString():null);
        System.out.printf(pager!=null?pager.toString():null);
        System.out.printf("===========================");
        List<StaBrokenRecord> list = service.getAll(record,pager);
        int total = service.countAll(record);
        PageData pageData = new PageData(list,total);
        return pageData;
    }

    @RequestMapping("/add")
    @Transactional
    @ApiOperation(value="断站信息添加接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json add(StaBrokenRecord record, HttpServletRequest req){
        if(record == null){
            return new ErrorJson("断站编号和断站编码不能为空！");
        }
        String id = AppUtil.getUUID();
        record.setBrokenNum(id);
        service.add(record);
        return new SuccessJson("添加成功!",record);

    }

    @RequestMapping("/update")
    @Transactional
    @ApiOperation(value="断站信息编辑接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json update(StaBrokenRecord record, HttpServletRequest req){
        if(record == null){
            return new ErrorJson("参数不能为空！");
        }
        StaBrokenRecord area = service.getById(record.getBrokenNum());
        if(area!=null){
            service.update(record);
            return new SuccessJson("编辑成功!",record);
        }else{
            return new ErrorJson("编辑失败，不存在该条记录！");
        }
    }

    @RequestMapping("/delete")
    @Transactional
    @ApiOperation(value="断站信息删除接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json delete(String brokenNum, HttpServletRequest req){
        if(brokenNum == null || "".equals(brokenNum) ){
            return new ErrorJson("断站编号不能为空！");
        }
        StaBrokenRecord area = service.getById(brokenNum);
        if(area!=null){
            service.delete(brokenNum);
            return new SuccessJson("删除成功!",area);
        }else{
            return new ErrorJson("删除失败，不存在该条记录！");
        }
    }

}
