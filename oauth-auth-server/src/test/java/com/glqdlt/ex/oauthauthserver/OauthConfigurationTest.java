package com.glqdlt.ex.oauthauthserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author glqdlt
 * 2019-02-18
 */
@ActiveProfiles
@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void loadUserDeatils() throws Exception {
        applicationContext.getBean("userDetailsService");
    }
}