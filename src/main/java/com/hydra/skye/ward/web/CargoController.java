package com.hydra.skye.ward.web;

import com.google.common.base.Preconditions;
import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CargoQueryCondition;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.model.vo.CargoVo;
import com.hydra.skye.ward.service.CargoService;
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
import java.util.List;

/**
 * Created by yahto on 21/03/2018
 */
@RequestMapping("/api/cargo")
@Controller
@Api(value = "货物管理", description = "货物API")
public class CargoController {
    @Autowired
    private CargoService cargoService;


    @RequestMapping(value = "/stockBack.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "返库", notes = "返库", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cargoId", value = "货物ID", dataType = "Long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "backNum", value = "返库片数", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "backArea", value = "返库面积", dataType = "Double", required = true, paramType = "query")
    })
    public Result stockBack(@RequestParam("cargoId") Long cargoId,
                            @RequestParam("backNum") Integer backNum,
                            @RequestParam("backArea") Double backArea,
                            HttpServletRequest request) {
        Preconditions.checkNotNull(cargoId);
        Preconditions.checkNotNull(backArea);
        Preconditions.checkNotNull(backNum);
//        User user = (User) request.getSession().getAttribute("current_user");
//        if (user == null) {
//            return new Result().fail("未登录", DataCode.NOLOGIN);
//        }
        try {
            cargoService.stockBack(cargoId, backNum, backArea, 1L);
        } catch (BusinessException e) {
            return new Result().fail(e.getMessage(), DataCode.SERVICEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "/queryCargoByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    public Result queryCargoByCondition(CargoQueryCondition cargoQueryCondition, PageBean pageBean) {
        List<CargoVo> voList = cargoService.queryCargoByCondition(cargoQueryCondition, pageBean);
        return new Result().success().add("voList", voList).add("page", pageBean);
    }
}
