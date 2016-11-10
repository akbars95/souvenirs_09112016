package com.mtsmda.souvenir0911;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by dminzat on 11/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring/mvc/dispatcherServlet.xml", "classpath:spring/spring-souvenir-*"})
@WebAppConfiguration
public class ParentTest {

}