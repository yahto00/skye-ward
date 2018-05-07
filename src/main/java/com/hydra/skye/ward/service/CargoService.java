package com.hydra.skye.ward.service;

import com.github.pagehelper.PageInfo;
import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CargoQueryCondition;
import com.hydra.skye.ward.model.dto.OrderItemDto;
import com.hydra.skye.ward.model.vo.CargoVo;

import java.util.List;

/**
 * Created by yahto on 21/03/2018
 */
public interface CargoService {
    boolean createCargo(Cargo cargo);

    void stockBack(Long cargoId, Integer backNum, Double backArea, Long opUserId);

    boolean oldStockOut(Cargo cargo);

    List<Cargo> queryBackCargoByDozenId(Long id);

    int clear();

    List<CargoVo> queryCargoByCondition(CargoQueryCondition cargoQueryCondition, PageBean pageBean);

    boolean createOrder(OrderItemDto dto);
}
