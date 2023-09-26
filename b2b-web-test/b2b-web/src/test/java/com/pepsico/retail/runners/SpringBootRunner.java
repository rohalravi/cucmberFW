/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.runners;
import lombok.extern.slf4j.Slf4j;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@CucumberContextConfiguration
@SpringBootTest
public class SpringBootRunner {
    @Before
    public void setupCucumberSpringContext() {
        log.info("Setting up cucumber context","Web Application");
    }
}
