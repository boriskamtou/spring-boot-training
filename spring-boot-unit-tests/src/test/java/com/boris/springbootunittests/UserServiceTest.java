package com.boris.springbootunittests;

import com.boris.springbootunittests.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class) // @RunWith: integrate spring with junit
@SpringBootTest
// @SpringBootTest: this class is spring boot test.
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testGetUser() {
        Assert.assertEquals(userService.getUser(), "Boris");
    }
}