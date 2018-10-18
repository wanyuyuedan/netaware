package com.unicom.controller;

import com.unicom.model.*;
import com.unicom.service.StaAreaService;
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
@Api(value="小区信息管理接口")
@RequestMapping("/staArea")
public class StaAreaController extends BaseController {

    @Autowired
    private StaAreaService service;

    /**
     * 通过areaId查询
     * @param areaId
     * @param req
     * @return
     */
    @RequestMapping("/get")
    @ApiOperation(value="单条记录查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "areaId", value = "小区编号", required = true, dataType = "String")
    public Json queryByAreaId(String areaId, HttpServletRequest req){
        if(areaId == null || "".equals(areaId)){
            return new ErrorJson("小区编号不能为空！");
        }
        StaArea area = service.getByAreaId(areaId);
        if(area!=null){
            return new SuccessJson("查询成功!",area);
        }else{
            return new ErrorJson("查询失败，找不到任何记录！");
        }
    }

    @RequestMapping("/getAll")
    @ApiOperation(value="单条记录查询接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParam(paramType="query", name = "areaId", value = "小区编号", required = true, dataType = "String")
    public PageData queryByAreaId(StaArea staArea,Pager pager, HttpServletRequest req){

        List<StaArea> list = service.getAll(staArea,pager);
        int total = service.countAll(staArea);
        PageData pageData = new PageData(list,total);
        return pageData;
    }

    @RequestMapping("/add")
    @Transactional
    @ApiOperation(value="小区信息添加接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json add(StaArea staArea, HttpServletRequest req){
        if(staArea == null){
            return new ErrorJson("小区编号和小区编码不能为空！");
        }
        StaArea area = service.getByAreaId(staArea.getAreaId());
        if(area!=null){
            return new ErrorJson("添加失败，该编码的信息已存在！");
        }
        service.add(staArea);
        return new SuccessJson("添加成功!",staArea);

    }

    @RequestMapping("/update")
    @Transactional
    @ApiOperation(value="小区信息编辑接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json update(StaArea staArea, HttpServletRequest req){
        if(staArea == null){
            return new ErrorJson("小区编号和小区编码不能为空！");
        }
        StaArea area = service.getByAreaId(staArea.getAreaId());
        if(area!=null){
            service.update(staArea);
            return new SuccessJson("编辑成功!",staArea);
        }else{
            return new ErrorJson("编辑失败，不存在该条记录！");
        }
    }

    @RequestMapping("/delete")
    @Transactional
    @ApiOperation(value="小区信息删除接口", notes="test:返回json格式，success=true为成功否则为失败")
    public Json delete(String areaId, HttpServletRequest req){
        if(areaId == null || "".equals(areaId) ){
            return new ErrorJson("小区编号不能为空！");
        }
        StaArea area = service.getByAreaId(areaId);
        if(area!=null){
            service.delete(areaId);
            return new SuccessJson("删除成功!",area);
        }else{
            return new ErrorJson("删除失败，不存在该条记录！");
        }
    }

}
