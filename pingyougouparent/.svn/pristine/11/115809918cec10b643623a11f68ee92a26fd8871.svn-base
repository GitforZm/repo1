package test;


import com.pingyougou.dao.TbBrandMapper;
import com.pingyougou.pojo.TbBrand;
import com.pingyougou.service.SellerService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public  class test1 {


    @Autowired
    private TbBrandMapper tbBrandExample;
    @Autowired
    private SellerService sellerService;

    @Test
    public void  test(){
        System.out.println(tbBrandExample);
        System.out.println(sellerService);
       /* BCryptPasswordEncoder passwordEncoder  = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
        //$2a$10$a2nQAjUvkcpyFU0BktbzrupfdwWfLBOjVIC02F9oXAq53QpcsrrSS
        //$2a$10$9aM5OFL3cMgLR2pCYsIsmuLbCih0j7SRG5Y2vkaAkc6yEOC4EgbPy
        //$2a$10$cYm0S.qy95AW18DiIrqrn.ezLpzL4lcg6TFI0wTmpkIOIQxmgyf0a
        System.out.println(passwordEncoder.matches("123", "$2a$10$cYm0S.qy95AW18DiIrqrn.ezLpzL4lcg6TFI0wTmpkIOIQxmgyf0a"));
        System.out.println(passwordEncoder.matches("123", "$2a$10$a2nQAjUvkcpyFU0BktbzrupfdwWfLBOjVIC02F9oXAq53QpcsrrSS"));

  */

    }
}
