package xin.cymall.service.impl;

import javafx.application.Application;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.cymall.CyFastApplication;
import xin.cymall.entity.SrvFood;
import xin.cymall.service.SrvFoodService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CyFastApplication.class)
public class SrvFoodServiceImplTest extends TestCase {

    @Autowired
    private SrvFoodService srvFoodService;
    @Test
    public void testFindHealthFood() throws Exception {

        List<SrvFood> list = srvFoodService.findHealthFood(200);
        System.out.println(list.size());
    }
}