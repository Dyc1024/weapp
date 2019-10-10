package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.dao.ConplidateDao;
import test.dao.OrdersDao;
import test.dao.WorkDao;
import test.entity.Conplidate;
import test.entity.Orders;
import test.entity.Work;




@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private ConplidateDao conplidateDao;
	
	@Autowired
	private WorkDao workDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@RequestMapping(value="/apply")
	public void selectWorks(Long cid,Long wid) {
		Conplidate conplidate=conplidateDao.findByCid(cid);
		Work work=workDao.findByWid(wid);
		Orders orders=ordersDao.findOrders(conplidate, work);
		if (orders == null) {
			Orders order=new Orders();
			order.setConplidate(conplidate);
			order.setWorks(work);
			//持久化到数据库
			ordersDao.save(order);
		}
	}
	
	@RequestMapping(value="/findu")
	public Orders findUOrders(Long cid) {
		Conplidate conplidate=conplidateDao.findByCid(cid);
		Orders orders=ordersDao.findUOrders(conplidate);
		return orders;
	}
	
	
	
}
