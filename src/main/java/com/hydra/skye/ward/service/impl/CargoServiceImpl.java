package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.dao.CargoDao;
import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.CargoExample;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CargoQueryCondition;
import com.hydra.skye.ward.model.vo.CargoVo;
import com.hydra.skye.ward.service.CargoService;
import com.hydra.skye.ward.service.DozenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 21/03/2018
 */
@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoDao cargoDao;
    @Autowired
    private DozenService dozenService;

    @Override
    public boolean createCargo(Cargo cargo) {
        return cargoDao.insertSelective(cargo) > 0 ? true : false;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void stockBack(Long cargoId, Integer backNum, Double backArea, Long opUserId) {
        int res = cargoDao.stockBack(cargoId, backNum, backArea, new Date());
        if (res < 1) {
            throw new BusinessException("返库失败,请检查返库数量和返库面积");
        }
        Cargo cargo = cargoDao.selectByPrimaryKey(cargoId);
        if (cargo == null) {
            return;
        }
        if (!dozenService.stockBack(cargo.getDozenId(), backNum, backArea)) {
            throw new BusinessException("返库失败,请检查返库数量和返库面积");
        }
        Cargo backCargo = new Cargo();
        backCargo.setUpdateAt(new Date());
        backCargo.setCreateAt(new Date());
        backCargo.setStatus(2);
        backCargo.setCount(backNum);
        backCargo.setTotalArea(backArea);
        backCargo.setDozenId(cargo.getDozenId());
        backCargo.setLastOpUserId(opUserId);
        backCargo.setPrice(cargo.getPrice());
        if (!createCargo(backCargo)) {
            throw new BusinessException("返库失败,请检查返库数量和返库面积");
        }
    }

    @Override
    public boolean oldStockOut(Cargo cargo) {
        return cargoDao.oldStockOut(cargo, new Date()) > 0 ? true : false;
    }

    @Override
    public List<Cargo> queryBackCargoByDozenId(Long id) {
        CargoExample example = new CargoExample();
        example.createCriteria().andDozenIdEqualTo(id).andStatusEqualTo(2);
        List<Cargo> cargoList = cargoDao.selectByExample(example);
        return cargoList == null ? new ArrayList<Cargo>() : cargoList;
    }

    @Override
    public int clear() {
        CargoExample example = new CargoExample();
        example.createCriteria().andCountEqualTo(0);
        return cargoDao.deleteByExample(example);
    }

    @Override
    public List<CargoVo> queryCargoByCondition(CargoQueryCondition cargoQueryCondition, PageBean pageBean) {
        Integer limitY = pageBean.getPageSize();
        Page<CargoVo> result = PageHelper.startPage(pageBean.getPageIndex(), limitY);
        List<CargoVo> voList = cargoDao.queryCargoByCondition(cargoQueryCondition);
        pageBean.setCounts(result.getTotal());
        return voList == null ? Lists.newArrayList() : voList;
    }
}
