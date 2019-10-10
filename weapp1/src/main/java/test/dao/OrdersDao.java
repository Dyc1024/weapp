package test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import test.entity.Conplidate;

import test.entity.Orders;

import test.entity.Work;


public interface OrdersDao extends JpaRepository<Orders, Long>{
	
	@Query("select o from Orders o where o.conplidate=?1 and o.works=?2")
	public Orders findOrders(Conplidate conplidate, Work work);
	
	@Query("select o from Orders o where o.conplidate=?1 ")
	public Orders findUOrders(Conplidate conplidate);
	
	public Orders findByOid(Long oid);
}
