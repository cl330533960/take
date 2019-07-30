package xin.cymall.service.impl;

import javafx.application.Application;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.cymall.CyFastApplication;
import xin.cymall.dao.SrvRestaurantDao;
import xin.cymall.entity.SrvFood;
import xin.cymall.entity.SrvRestaurant;
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
    @Autowired
    private SrvRestaurantDao srvRestaurantDao;
    @Test
    public void testFindHealthFood() throws Exception {

        SrvRestaurant srvRestaurant = srvRestaurantDao.get("54f1604b647f4687a42ae6c9aae28c57");
        System.out.println(srvRestaurant.getClientId());
    }
}