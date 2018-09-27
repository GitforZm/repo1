package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.dao.TbBrandMapper;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.ResultInfo;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.pojo.TbBrandExample;
import com.pingyougou.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImp implements IBrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    private  ResultInfo resultInfo = new ResultInfo();

    @Override
    public List <TbBrand> getAll() {
        System.out.println(tbBrandMapper);
        List <TbBrand> tbBrands = tbBrandMapper.selectByEasy();
        return tbBrands;

    }

    @Override
    public PageResult getPage(int pageNum, int pageSize) {
        //PageHelper为MyBatis分页插件
        //PageHelper类传入两个参数 当前页数和每页显示条数
      PageHelper.startPage(pageNum,pageSize);
        //得到总数
        Page<TbBrand> page=(Page<TbBrand>)tbBrandMapper.selectByEasy();
        List <TbBrand> result = page.getResult();
        return new PageResult( result,page.getTotal());
    }

    @Override
    public TbBrand findOne(long id) {
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    @Override
    public ResultInfo update( TbBrand entity) {
        int i = tbBrandMapper.updateByPrimaryKey(entity);
        if(i>0){resultInfo.setSuccess(true);}
        else{resultInfo.setSuccess(false);resultInfo.setMessage("更新失败");}
        return resultInfo ;
    }

    @Override
    public ResultInfo add(@RequestBody TbBrand entity) {
        int insert = tbBrandMapper.insert(entity);
        if(insert>0){resultInfo.setSuccess(true);}
        else{resultInfo.setSuccess(false);resultInfo.setMessage("添加失败");}
        return resultInfo ;
    }

    @Override
    public ResultInfo delete(String [] ids) {
        for (String id : ids) {
            int i = tbBrandMapper.deleteByPrimaryKey(Long.parseLong(id));
            if(i>0){resultInfo.setSuccess(true);}
            else {resultInfo.setSuccess(false); resultInfo.setMessage("删除失败");}
        }
        return resultInfo;
    }
    /**
    * @Description: 条件查询
    * @Param: [pageNum, pageSize, brand]
    */

    @Override
    public PageResult search(int pageNum, int pageSize, TbBrand brand) {
        PageHelper.startPage(pageNum, pageSize);//分页
        //创建条件实体类 对象
        TbBrandExample example=new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }

        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);

        return new PageResult( page.getResult(),page.getTotal());
    }

    @Override
    public List <Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}
