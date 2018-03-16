package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.KindExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindDao {
    int countByExample(KindExample example);

    int deleteByExample(KindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Kind record);

    int insertSelective(Kind record);

    List<Kind> selectByExample(KindExample example);

    Kind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Kind record, @Param("example") KindExample example);

    int updateByExample(@Param("record") Kind record, @Param("example") KindExample example);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);
}