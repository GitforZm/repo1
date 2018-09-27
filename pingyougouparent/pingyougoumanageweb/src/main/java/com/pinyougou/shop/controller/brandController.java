package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.entity.PageResult;
import com.pingyougou.entity.ResultInfo;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.service.IBrandService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/brand")
@RestController
public class brandController {
    @Reference
    private IBrandService iBrandService;
    @RequestMapping("/getAll")
    public List<TbBrand> getAll(){
    return iBrandService.getAll();
    }
    /**
    * @Description: 分页查询
    * @Param: [page, size]
    */
    @RequestMapping("/getPage") public PageResult getPage(String page , String rows){

        int num = Integer.parseInt(page);
        int size1 = Integer.parseInt(rows);
        return iBrandService.getPage(num,size1);
    }
    @RequestMapping("/update") public ResultInfo update(@RequestBody TbBrand entity){
        System.out.println(entity);
      return   iBrandService.update(entity);

    }
     @RequestMapping("/add") public ResultInfo add(@RequestBody TbBrand entity){
         System.out.println(entity);
         return iBrandService.add(entity);

    }
     @RequestMapping("/findOne") public  TbBrand findOne(String id){

            return iBrandService.findOne(Integer.parseInt(id));

    }
      @RequestMapping("/delete") public ResultInfo delete(String [] ids){
           return  iBrandService.delete(ids);

    }
    @RequestMapping("/search") public PageResult search(String page , String rows ,@RequestBody TbBrand searchEntity){

        int num = Integer.parseInt(page);
        int size1 = Integer.parseInt(rows);

        return iBrandService.search(num,size1,searchEntity);
    }
    @RequestMapping("/selectOptionList") public List<Map> selectOptionList(){

        List <Map> maps = iBrandService.selectOptionList();
        return maps;
    }





}
