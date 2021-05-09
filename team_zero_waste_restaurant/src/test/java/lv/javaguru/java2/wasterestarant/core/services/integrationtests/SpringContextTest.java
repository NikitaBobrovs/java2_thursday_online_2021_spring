package lv.javaguru.java2.wasterestarant.core.services.integrationtests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lv.javaguru.java2.wasterestarant.config.RestaurantApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestaurantApplicationConfiguration.class})
public class SpringContextTest {

    @Autowired private ApplicationContext appContext;

    @Test
    public void start() {
        assertNotNull(appContext);
    }

}
