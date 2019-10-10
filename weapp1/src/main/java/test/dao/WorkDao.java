package test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import test.entity.User;
import test.entity.Work;


public interface WorkDao extends JpaRepository<Work, Long>{
	public Work findByWid(Long wid);
	
	public List<Work> findByWtype(String wtype);
	
	@Query("select w from Work w where w.user=?1")
	public List<Work> findWorks(User user);
}
