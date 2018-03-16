package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Dozen;
import com.hydra.skye.ward.model.DozenExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}