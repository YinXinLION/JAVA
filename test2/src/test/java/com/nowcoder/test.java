package com.nowcoder;

import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by 殷鑫 on 2017/1/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WendaApplication.class)
@Sql("/init-schema.sql")
public class test {
    @Autowired
    UserDAO userDAO;
    @Test
    public void initDatabase(){
//        插入
        Random random = new Random();
        for (int i = 0; i < 11; ++i){
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png",random.nextInt(1000)));
            user.setName(String.format("User%d",i));
            user.setPassword("");
            user.setSalt("");
            userDAO.addUser(user);

            user.setPassword("xx");
            userDAO.updatePassword(user);
        }

        Assert.assertEquals("xx",userDAO.selectById(1).getPassword());
    }
}
