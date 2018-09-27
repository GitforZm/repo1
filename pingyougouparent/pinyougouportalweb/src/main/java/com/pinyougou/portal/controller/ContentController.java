package com.pinyougou.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pingyougou.pojo.TbContent;
import com.pinyougou.content.service.ContentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Reference
    private ContentService contentService;

    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(long id){
        System.out.println(id);
        List <TbContent> byCategoryId = contentService.findByCategoryId(id);
        System.out.println(byCategoryId);
        return byCategoryId;
    }
}
