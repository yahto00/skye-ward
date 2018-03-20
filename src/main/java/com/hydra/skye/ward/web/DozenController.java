package com.hydra.skye.ward.web;

import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.model.vo.DozenVo;
import com.hydra.skye.ward.service.DozenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by yahto on 20/03/2018
 */
@RequestMapping("/api/dozen")
@Controller
@Api(value = "扎管理接口", description = "扎管理API")
public class DozenController {
    @Autowired
    private DozenService dozenService;

    @RequestMapping(value = "/createDozen.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建新扎", notes = "创建新扎", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kindId", value = "种类Id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "totalCount", value = "扎包含的总片数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "totalArea", value = "扎的总面积", required = true, paramType = "query")
    })
    public Result createDozen(@RequestParam("kindId") Long kindId,
                              @RequestParam("totalCount") Integer totalCount,
                              @RequestParam("totalArea") Double totalArea,
                              HttpServletRequest request) {
//        User currentUser = (User) request.getSession().getAttribute("current_user");
//        if (currentUser == null) {
//            return new NoLoginResult();
//        }
        Dozen dozen = new Dozen();
        dozen.setCreateAt(new Date());
        dozen.setKindId(kindId);
//        dozen.setLastOpUserId(currentUser.getId());
        dozen.setLastOpUserId(1L);
        dozen.setStatus(0);
        dozen.setUpdateAt(new Date());
        dozen.setLeftArea(totalArea);
        dozen.setLeftCount(totalCount);
        dozen.setTotalArea(totalArea);
        dozen.setTotalCount(totalCount);
        dozen.setNumber(UUID.randomUUID().toString().replace("-", ""));
        if (!dozenService.createDozen(dozen)) {
            return Result.fail("创建失败");
        }
        return Result.success();
    }

    @RequestMapping(value = "/queryDozenByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "条件查询扎", notes = "条件查询扎", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createAt", value = "创建时间", dataType = "Date", required = false, paramType = "query"),
            @ApiImplicitParam(name = "kindName", value = "种类名称", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "number", value = "扎编号", dataType = "String", required = false, paramType = "query")
    })
    public Result queryDozenByCondition(DozenQueryCondition condition, PageBean pageBean) {
        List<DozenVo> voList = dozenService.queryDozenByCondition(condition, pageBean);
        return Result.success().addData("voList", voList).addData("page", pageBean);
    }
}
