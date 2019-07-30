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
import xin.cymall.service.SrvOrderService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CyFastApplication.class)
public class SrvFoodServiceImplTest extends TestCase {

    @Autowired
    private SrvFoodService srvFoodService;
    @Autowired
    private SrvOrderService srvOrderService;
    @Test
    public void testFindHealthFood() throws Exception {
        srvOrderService.updateOrderSuccessCallback("120190730142937524");
    }
}