package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Kind;
import com.hydra.skye.ward.model.KindExample;
import com.hydra.skye.ward.model.condition.KindQueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    List<Kind> queryKindByCondition(@Param("condition") KindQueryCondition condition);

    int deleteKindById(@Param("kindId") Long kindId);

    int updateKindById(@Param("name") String name,
                       @Param("kindId") Long kindId,
                       @Param("updateAt") Date updateAt);

    List<Kind> queryAllKind();
}