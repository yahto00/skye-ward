package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.vo.DozenVo;

import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
public interface DozenService {
    boolean createDozen(Dozen dozen);

    List<DozenVo> queryDozenByCondition(DozenQueryCondition condition, PageBean pageBean);
}
