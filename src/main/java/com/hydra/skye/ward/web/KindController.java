package com.hydra.skye.ward.web;

import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.service.KindService;
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

import java.util.Date;

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
            return Result.fail("添加失败");
        }
        return Result.success();
    }

}
