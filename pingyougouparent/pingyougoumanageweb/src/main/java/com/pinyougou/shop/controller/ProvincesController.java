package com.pinyougou.shop.controller;
import java.util.List;

import com.pingyougou.pojo.TbProvinces;
import com.pingyougou.service.ProvincesService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.ResultInfo;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/provinces")
public class ProvincesController {

	@Reference
	private ProvincesService provincesService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbProvinces> findAll(){			
		return provincesService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return provincesService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param provinces
	 * @return
	 */
	@RequestMapping("/add")
	public ResultInfo add(@RequestBody TbProvinces provinces){
		try {
			provincesService.add(provinces);
			return new ResultInfo(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param provinces
	 * @return
	 */
	@RequestMapping("/update")
	public ResultInfo update(@RequestBody TbProvinces provinces){
		try {
			provincesService.update(provinces);
			return new ResultInfo(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbProvinces findOne(Long id){
		return provincesService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultInfo delete(Long [] ids){
		try {
			provincesService.delete(ids);
			return new ResultInfo(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbProvinces provinces, int page, int rows  ){
		return provincesService.findPage(provinces, page, rows);		
	}
	
}
