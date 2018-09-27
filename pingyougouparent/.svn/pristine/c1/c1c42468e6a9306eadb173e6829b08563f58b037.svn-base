package com.pinyougou.sellergoods.service.impl;
import java.util.List;

import com.pingyougou.dao.TbSpecificationMapper;
import com.pingyougou.dao.TbSpecificationOptionMapper;
import com.pingyougou.entity.ResultInfo;
import com.pingyougou.pojo.*;
import com.pingyougou.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pingyougou.pojo.TbSpecificationExample.Criteria;

import com.pingyougou.entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getResult(), page.getTotal());
	}

	/**
	* @Description: 添加规格 和规格列表
	* @Param: [specification]
	* @Date: 2018/9/14
	*/

	@Override
	public ResultInfo add(Specification specification) {

		specificationMapper.insert(specification.getSpecification());
		System.out.println("拿到Id了吗?"+specification.getSpecification().getId());
		List <TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();

		for (TbSpecificationOption tbSpecificationOption : specificationOptionList) {
			tbSpecificationOption.setSpecId(specification.getSpecification().getId());
			System.out.println(tbSpecificationOption);
			specificationOptionMapper.insert(tbSpecificationOption);
		}

        return new ResultInfo(true,"增加成功");
    }

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSpecification specification){
		specificationMapper.updateByPrimaryKey(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
        Specification specification = new Specification();
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        specification.setSpecification(tbSpecification);
        //集合
        TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
        com.pingyougou.pojo.TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(id);

        List <TbSpecificationOption> tbSpecificationOptions = specificationOptionMapper.selectByExample(tbSpecificationOptionExample);
        specification.setSpecificationOptionList(tbSpecificationOptions);
		System.out.println(tbSpecificationOptions.size());
        return specification;


    }

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getResult(), page.getTotal());
	}
	
}
