package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Vitrolite;
import com.hydra.skye.ward.model.VitroliteExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitroliteDao {
    int countByExample(VitroliteExample example);

    int deleteByExample(VitroliteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vitrolite record);

    int insertSelective(Vitrolite record);

    List<Vitrolite> selectByExample(VitroliteExample example);

    Vitrolite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vitrolite record, @Param("example") VitroliteExample example);

    int updateByExample(@Param("record") Vitrolite record, @Param("example") VitroliteExample example);

    int updateByPrimaryKeySelective(Vitrolite record);

    int updateByPrimaryKey(Vitrolite record);
}