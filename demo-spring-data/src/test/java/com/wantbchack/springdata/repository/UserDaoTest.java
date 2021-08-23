package com.wantbchack.springdata.repository;


import com.alibaba.fastjson.JSON;
import com.wantbchack.springdata.entity.User;
import com.wantbchack.springdata.SpringBootDemoOrmJpaApplicationTests;

import com.wantbchack.springdata.entity.UserClass;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.Optional;


/**
 * <p>
 * jpa 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-07 14:09
 */
@Slf4j
public class UserDaoTest extends SpringBootDemoOrmJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserClassRepository userClassRepository;

    @Test
    public void test01(){

        Optional<User> byId = userRepository.findById(1);
        User user = byId.get();
        String s = JSON.toJSONString(user);
        log.info("{}",s);
    }

}
