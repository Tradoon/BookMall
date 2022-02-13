package com.tradoon.mallmbg;

import com.tradoon.mallmbg.dao.UmsAdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallMbgApplicationTests {
    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Test
    void contextLoads() {
        System.out.println(umsAdminMapper);
    }

}
