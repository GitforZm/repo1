import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext*.xml")
public class testClass {
    @Autowired
    private RedisTemplate redisTemplate;
    //Set使用member拿到值
    @Test
    public  void setValue(){
       redisTemplate.boundValueOps("name").set("张三");
        System.out.println((String) redisTemplate.boundValueOps("name").get());
        redisTemplate.boundSetOps("nameSet").add("曹操");
        redisTemplate.boundSetOps("nameSet").add("刘备");
        redisTemplate.boundSetOps("nameSet").add("孙权");
        Set name =  redisTemplate.boundSetOps("nameSet").members();
        System.out.println(name);
    }
    @Test
    public  void setL(){
       redisTemplate.boundListOps("man").rightPush("曹操");
       redisTemplate.boundListOps("man").rightPush("孙权");
       redisTemplate.boundListOps("man").rightPush("刘备");
        List name = redisTemplate.boundListOps("man").range(0, 10);
        System.out.println(name);
    }  
    @Test
    public  void setList(){
       redisTemplate.boundListOps("man").leftPush("曹操");
       redisTemplate.boundListOps("man").leftPush("孙权");
       redisTemplate.boundListOps("man").leftPush("刘备");
        List name = redisTemplate.boundListOps("man").range(0, 100);
        System.out.println(name);
    }
    @Test
    public void testHash(){
        redisTemplate.boundHashOps("nameHash").put("a","唐僧");
        redisTemplate.boundHashOps("nameHash").put("b","白骨精");
        redisTemplate.boundHashOps("nameHash").put("c","孙悟空");
        System.out.println(redisTemplate.boundHashOps("nameHash").keys());
        System.out.println(redisTemplate.boundHashOps("nameHash").values());
    }

}
