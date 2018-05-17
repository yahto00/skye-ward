package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CargoQueryCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yahto on 26/03/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CargoServiceTest {
    @Autowired
    private CargoService cargoService;

    @Test
    public void queryConditionTest() {
        System.out.println(cargoService.queryCargoByCondition(new CargoQueryCondition(), new PageBean()));
    }
}
