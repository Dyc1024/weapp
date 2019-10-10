 package test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.dao.UserDao;
import test.dao.WorkDao;
import test.entity.User;
import test.entity.Work;

@RestController
 @RequestMapping("/works")
public class WorkController {
	@Autowired
	private WorkDao workDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/list")
	public Map<String, Object> listWork(){
		List<Work>list=workDao.findAll();
		Map<String, Object> result=new HashMap<>();
		result.put("total", list.size());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping("/getbytype")
	public List<Work> listWork(String wtype){
		List<Work> list=workDao.findByWtype(wtype);
		return list;
	}
	
	@RequestMapping("/getbyuser")
	public Map<String, Object> listWorks(Long uid){
		User user=userDao.findByUid(uid);
		List<Work> list=workDao.findWorks(user);
		Map<String, Object> result=new HashMap<>();
		result.put("total", list.size());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping("/issumwork")
	public Work issumwork(Long uid,String wordertype,String wphone,String wemail,String wtype,String wresum,String wcompany,String wlicence) {
		Work work=new Work();
		User user=userDao.findByUid(uid);
		work.setUser(user);
		work.setWordertype(wordertype);
		work.setWphone(wphone);
		work.setWemail(wemail);
		work.setWtype(wtype);
		work.setWresum(wresum);
		work.setWcompany(wcompany);
		work.setWlicence(wlicence);
		workDao.save(work);
		System.out.println("已发布工作");
		return work;
	}
}
