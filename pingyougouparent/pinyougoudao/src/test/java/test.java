import com.pingyougou.dao.TbBrandMapper;
import com.pingyougou.pojo.TbAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml")
public  class test {

    @Autowired
    private  TbBrandMapper tbBrandMapper;
    @Test
    public void  test(){

        System.out.println(tbBrandMapper);
        System.out.println(new TbAddress());
    }
}
