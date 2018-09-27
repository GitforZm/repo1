package com.pingyougou.service;

import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.ResultInfo;
import com.pingyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface IBrandService {
    List <Map> selectOptionList();
    List<TbBrand> getAll();
    PageResult getPage(int pageNum , int pageSize);
    PageResult search(int pageNum , int pageSize ,TbBrand tbBrand);
    TbBrand findOne(long id);
    ResultInfo update(TbBrand entity);
    ResultInfo add(TbBrand entity);
    ResultInfo delete(String[] ids);

}
