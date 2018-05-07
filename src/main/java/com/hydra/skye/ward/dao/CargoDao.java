package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.CargoExample;
import com.hydra.skye.ward.model.condition.CargoQueryCondition;
import com.hydra.skye.ward.model.dto.OrderItemDto;
import com.hydra.skye.ward.model.vo.CargoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CargoDao {
    int countByExample(CargoExample example);

    int deleteByExample(CargoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    List<Cargo> selectByExample(CargoExample example);

    Cargo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByExample(@Param("record") Cargo record, @Param("example") CargoExample example);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);

    int stockBack(@Param("cargoId") Long cargoId,
                  @Param("backNum") Integer backNum,
                  @Param("backArea") Double backArea,
                  @Param("updateAt") Date updateAt);

    int oldStockOut(@Param("cargo") Cargo cargo,
                    @Param("updateAt") Date updateAt);

    List<CargoVo> queryCargoByCondition(@Param("condition") CargoQueryCondition cargoQueryCondition);

    int createOrder(@Param("dto") OrderItemDto dto, @Param("updateAt") Date updateAt);
}