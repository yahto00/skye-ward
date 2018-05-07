package com.hydra.skye.ward.web;

import com.google.common.base.Preconditions;
import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.model.vo.DozenVo;
import com.hydra.skye.ward.service.CargoService;
import com.hydra.skye.ward.service.DozenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
    @Autowired
    private CargoService cargoService;

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
            return new Result().fail("创建失败", DataCode.DATABASEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "/queryDozenByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "条件查询扎", notes = "条件查询扎", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "createAt", value = "创建时间", dataType = "Date", required = false, paramType = "query"),
            @ApiImplicitParam(name = "endAt", value = "查询结束时间", dataType = "Date", required = false, paramType = "query"),
            @ApiImplicitParam(name = "kindName", value = "种类名称", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "number", value = "扎编号", dataType = "String", required = false, paramType = "query")
    })
    public Result queryDozenByCondition(DozenQueryCondition condition, PageBean pageBean) {
        List<DozenVo> voList = dozenService.queryDozenByCondition(condition, pageBean);
        if (!CollectionUtils.isEmpty(voList)) {
            for (DozenVo dozenVo : voList) {
                dozenVo.setBackCargoList(cargoService.queryBackCargoByDozenId(dozenVo.getId()));
            }
        }
        return new Result().success().add("voList", voList).add("page", pageBean);
    }

    @RequestMapping(value = "/stockOut.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "原材料出库", notes = "原材料出库", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dozenId", value = "扎ID", dataType = "Long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "outCount", value = "出库片数", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "outArea", value = "出库面积", dataType = "Double", required = true, paramType = "query"),
            @ApiImplicitParam(name = "price", value = "出库总价格", dataType = "Double", required = true, paramType = "query")
    })
    public Result stockOut(@RequestParam("dozenId") Long dozenId,
                           @RequestParam("outCount") Integer outCount,
                           @RequestParam("outArea") Double outArea,
                           @RequestParam("price") Double price,
                           HttpServletRequest request) {
        Preconditions.checkNotNull(dozenId);
        Preconditions.checkNotNull(outCount);
        Preconditions.checkNotNull(outArea);
        Preconditions.checkNotNull(price);
//        User user = (User) request.getSession().getAttribute("current_user");
//        if (user == null) {
//            return new Result().fail("未登录", DataCode.NOLOGIN);
//        }
        Cargo cargo = new Cargo();
        cargo.setCount(outCount);
        cargo.setCreateAt(new Date());
        cargo.setTotalArea(outArea);
        cargo.setPrice(price);
//        cargo.setLastOpUserId(user.getId());
        cargo.setLastOpUserId(1L);
        cargo.setDozenId(dozenId);
        cargo.setUpdateAt(new Date());
        cargo.setStatus(0);
        try {
            dozenService.stockOut(cargo);
        } catch (BusinessException e) {
            return new Result().fail(e.getMessage(), DataCode.SERVICEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "/oldStockOut.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "返库板材出库", notes = "返库板材出库", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dozenId", value = "扎ID", dataType = "Long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cargoId", value = "板材ID", dataType = "Long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "outCount", value = "出库片数", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "outArea", value = "出库面积", dataType = "Double", required = true, paramType = "query"),
            @ApiImplicitParam(name = "price", value = "出库总价格", dataType = "Double", required = true, paramType = "query")
    })
    public Result oldStockOut(@RequestParam("dozenId") Long dozenId,
                              @RequestParam("cargoId") Long cargoId,
                              @RequestParam("outCount") Integer outCount,
                              @RequestParam("outArea") Double outArea,
                              @RequestParam("price") Double price,
                              HttpServletRequest request) {
        Preconditions.checkNotNull(cargoId);
        Preconditions.checkNotNull(outArea);
        Preconditions.checkNotNull(outCount);
        Preconditions.checkNotNull(dozenId);
        Preconditions.checkNotNull(price);
//        User user = (User) request.getSession().getAttribute("current_user");
//        if (user == null) {
//            return new Result().fail("未登录", DataCode.NOLOGIN);
//        }
        Cargo cargo = new Cargo();
        cargo.setCount(outCount);
        cargo.setId(cargoId);
        cargo.setCreateAt(new Date());
        cargo.setTotalArea(outArea);
        cargo.setPrice(price);
//        cargo.setLastOpUserId(user.getId());
        cargo.setLastOpUserId(1L);
        cargo.setDozenId(dozenId);
        cargo.setUpdateAt(new Date());
        cargo.setStatus(0);
        try {
            dozenService.oldStockOut(cargo);
        } catch (BusinessException e) {
            return new Result().fail(e.getMessage(), DataCode.SERVICEERROR);
        }
        return new Result().success();
    }
}
