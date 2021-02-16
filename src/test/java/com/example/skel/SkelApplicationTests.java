package com.example.skel;

import com.example.skel.appresource.UserRestFunctional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SkelApplication.class)
class SkelApplicationTests {

    @Autowired
    private UserRestFunctional userRestFunctional;
    @Test
    void contextLoads() throws Exception {
        assertThat(userRestFunctional).isNotNull();
    }

}
