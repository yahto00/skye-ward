package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.dao.DozenDao;
import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.vo.DozenVo;
import com.hydra.skye.ward.service.DozenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
@Service
public class DozenServiceImpl implements DozenService {
    @Autowired
    private DozenDao dozenDao;

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
}
