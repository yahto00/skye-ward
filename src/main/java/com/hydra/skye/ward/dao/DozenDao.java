package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Cargo;
import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.DozenExample;
import com.hydra.skye.ward.model.condition.DozenQueryCondition;
import com.hydra.skye.ward.model.vo.DozenVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DozenDao {
    int countByExample(DozenExample example);

    int deleteByExample(DozenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dozen record);

    int insertSelective(Dozen record);

    List<Dozen> selectByExample(DozenExample example);

    Dozen selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dozen record, @Param("example") DozenExample example);

    int updateByExample(@Param("record") Dozen record, @Param("example") DozenExample example);

    int updateByPrimaryKeySelective(Dozen record);

    int updateByPrimaryKey(Dozen record);

    List<DozenVo> queryDozenByCondition(@Param("condition") DozenQueryCondition condition);

    int stockOut(@Param("cargo") Cargo cargo, @Param("updateAt") Date updateAt);

    int stockBack(@Param("dozenId") Long dozenId,
                  @Param("backNum") Integer backNum,
                  @Param("backArea") Double backArea,
                  @Param("updateAt") Date updateAt);

    int clear();
}