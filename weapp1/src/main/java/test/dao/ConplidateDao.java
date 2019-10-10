package test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.entity.Conplidate;



public interface ConplidateDao extends JpaRepository<Conplidate, Long>{
	
	public Conplidate findByCid(Long cid);
	
	public List<Conplidate> findByCworktype(String cworktype);
	public Conplidate findByUid(Long uid);
}
