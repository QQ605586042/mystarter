package com.younger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class AppTest {
    @Autowired
    private Jedis jedis;
    @Test
    public void testJedis(){
        jedis.del("name");
    }

}
