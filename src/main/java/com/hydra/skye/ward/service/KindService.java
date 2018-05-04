package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.KindQueryCondition;

import java.util.List;

/**
 * Created by yahto on 20/03/2018
 */
public interface KindService {
    boolean createKind(Kind kind);

    List<Kind> queryKindByCondition(KindQueryCondition condition, PageBean pageBean);

    boolean deleteKindById(Long kindId);

    boolean updateKindById(String name, Long kindId);

    List<Kind> queryAllKind();
}
