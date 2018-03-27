package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.dao.DozenDao;
import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.DozenExample;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.vo.DozenVo;
import com.hydra.skye.ward.service.CargoService;
import com.hydra.skye.ward.service.DozenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
@Service
public class DozenServiceImpl implements DozenService {
    @Autowired
    private DozenDao dozenDao;

    @Autowired
    private CargoService cargoService;

    @Override
    public boolean createDozen(Dozen dozen) {
        return dozenDao.insertSelective(dozen) > 0 ? true : false;
    }

    @Override
    public List<DozenVo> queryDozenByCondition(DozenQueryCondition condition, PageBean pageBean) {
        Integer limitX = (pageBean.getPageIndex() - 1) * pageBean.getPageSize();
        Integer limitY = pageBean.getPageSize();
        Page<DozenVo> result = PageHelper.startPage(limitX, limitY);
        List<DozenVo> voList = dozenDao.queryDozenByCondition(condition);
        pageBean.setCounts(result.getTotal());
        return voList == null ? Lists.newArrayList() : voList;
    }

    @Transactional
    @Override
    public void stockOut(Cargo cargo) {
        int res = dozenDao.stockOut(cargo, new Date());
        if (res < 1) {
            //执行不成功，有可能是面积或者片数<0
            throw new BusinessException("出库失败,检查出库面积或者出库片数");
        }
        if (!cargoService.createCargo(cargo)) {
            throw new BusinessException("出库失败,请检查是否有错误填写");
        }
    }

    @Override
    public boolean stockBack(Long dozenId, Integer backNum, Double backArea) {
        return dozenDao.stockBack(dozenId, backNum, backArea, new Date()) > 0 ? true : false;
    }

    @Transactional
    @Override
    public void oldStockOut(Cargo cargo) {
        if (!cargoService.oldStockOut(cargo)) {
            throw new BusinessException("返库板材出库失败,请检查是否填写数据不规则");
        }
        cargo.setId(null);
        stockOut(cargo);
    }

    @Override
    public int clear() {
        return dozenDao.clear();
    }

}
