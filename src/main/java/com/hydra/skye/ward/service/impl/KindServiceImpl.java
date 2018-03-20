package com.hydra.skye.ward.service.impl;

import com.hydra.skye.ward.dao.KindDao;
import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
