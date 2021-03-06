package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.dao.KindDao;
import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.KindQueryCondition;
import com.hydra.skye.ward.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindDao kindDao;

    @Override
    public boolean createKind(Kind kind) {
        return kindDao.insertSelective(kind) > 0 ? true : false;
    }

    @Override
    public List<Kind> queryKindByCondition(KindQueryCondition condition, PageBean pageBean) {
        Integer limitY = pageBean.getPageSize();
        Page<Kind> result = PageHelper.startPage(pageBean.getPageIndex(), limitY);
        List<Kind> kindList = kindDao.queryKindByCondition(condition);
        pageBean.setCounts(result.getTotal());
        return kindList == null ? Lists.newArrayList() : kindList;
    }

    @Override
    public boolean deleteKindById(Long kindId) {
        return kindDao.deleteKindById(kindId) > 0 ? true : false;
    }

    @Override
    public boolean updateKindById(String name, Long kindId) {
        return kindDao.updateKindById(name, kindId, new Date()) > 0 ? true : false;
    }

    @Override
    public List<Kind> queryAllKind() {
        List<Kind> kindList = kindDao.queryAllKind();
        return kindList == null ? new ArrayList<Kind>() : kindList;
    }
}
