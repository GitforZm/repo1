package com.pingyougou.dao;

import com.pingyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

import com.pingyougou.pojo.TbBrandExample;
import org.apache.ibatis.annotations.Param;


public interface TbBrandMapper {
    List<Map> selectOptionList();
    int countByExample(TbBrandExample example);

    int deleteByExample(TbBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbBrand record);

    int insertSelective(TbBrand record);

    List<TbBrand> selectByExample(TbBrandExample example);
    List<TbBrand> selectByEasy();

    TbBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbBrand record, @Param("example") TbBrandExample example);

    int updateByExample(@Param("record") TbBrand record, @Param("example") TbBrandExample example);

    int updateByPrimaryKeySelective(TbBrand record);

    int updateByPrimaryKey(TbBrand record);
}