package com.hydra.skye.ward.web;

import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.KindQueryCondition;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.service.KindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
@RequestMapping("/api/kind")
@Controller
@Api(value = "种类管理", description = "种类管理API")
public class KindController {
    @Autowired
    private KindService kindService;

    @RequestMapping(value = "/createKind.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加新种类", notes = "添加新种类", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "种类名称", required = true, paramType = "query"),
    })
    public Result createKind(@RequestParam("name") String name) {
        Kind kind = new Kind();
        kind.setName(name);
        kind.setCreateAt(new Date());
        kind.setUpdateAt(new Date());
        if (!kindService.createKind(kind)) {
            return new Result().fail("添加失败", DataCode.DATABASEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "/queryKindByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "条件查询种类", notes = "条件查询种类", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kindName", value = "种类名称", required = false, paramType = "query"),
            @ApiImplicitParam(name = "createAt", value = "创建时间", required = false, paramType = "query"),
    })
    public Result queryKindByCondition(KindQueryCondition condition, PageBean pageBean) {
        List<Kind> kindList = kindService.queryKindByCondition(condition, pageBean);
        return new Result().success().add("kindList", kindList).add("page", pageBean);
    }

    @RequestMapping(value = "/deleteKindById.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "删除种类", notes = "删除种类", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kindId", value = "种类ID", required = false, paramType = "query"),
    })
    public Result deleteKindById(@RequestParam("kindId") Long kindId) {
        if (!kindService.deleteKindById(kindId)) {
            return new Result().fail("当前种类下还有关联扎,不能删除", DataCode.SERVICEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "updateKindById.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新种类", notes = "更新种类", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kindId", value = "种类ID", required = false, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "种类名称", required = false, paramType = "query"),
    })
    public Result updateKindById(@RequestParam("name") String name,
                                 @RequestParam("kindId") Long kindId) {
        if (StringUtils.isEmpty(name)) {
            return new Result().fail("种类名称不能为空", DataCode.SERVICEERROR);
        }
        if (!kindService.updateKindById(name, kindId)) {
            return new Result().fail("更新失败", DataCode.DATABASEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "queryAllKind.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新种类", notes = "更新种类", response = Result.class)
    public Result queryAllKind() {
        List<Kind> kindList = kindService.queryAllKind();
        return new Result().success().add("kindList", kindList);
    }

}
