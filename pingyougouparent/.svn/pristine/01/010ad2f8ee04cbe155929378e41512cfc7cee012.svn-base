package com.pinyougou.shop.controller;

import com.pingyougou.entity.ResultInfo;

import com.pingyougou.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private  String FILE_SERVER_URL;
    @RequestMapping("/upload")
    public ResultInfo upload(MultipartFile  file){
        ResultInfo resultInfo = new ResultInfo();

        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String substring=originalFilename.substring( originalFilename.lastIndexOf(".")+1);//得到扩展名
        System.out.println(substring);
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String path = fastDFSClient.uploadFile(file.getBytes(), substring);
            String url = FILE_SERVER_URL+ path ;
                 resultInfo.setSuccess(true);
            System.out.println(url);
                 resultInfo.setMessage(url);
                 return  resultInfo ;


        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setSuccess(false);
            resultInfo.setMessage("上传失败");
            return  resultInfo ;

        }
    }

}
