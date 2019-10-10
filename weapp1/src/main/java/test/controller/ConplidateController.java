package test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.dao.ConplidateDao;
import test.entity.Conplidate;


@RestController
@RequestMapping("/conplidate")
public class ConplidateController {
	@Autowired
	private ConplidateDao conplidateDao;

	
	@RequestMapping("/uploading")
	public Conplidate issumwork(Long uid,String cname,String cphone,String cemail,String cresum,String cworktype,String ccardnum,String ccollege,String czhuanye) {
		Conplidate conplidate=new Conplidate();
		conplidate.setUid(uid);
		conplidate.setCname(cname);
		conplidate.setCphone(cphone);
		conplidate.setCemail(cemail);
		conplidate.setCresum(cresum);
		conplidate.setCworktype(cworktype);
		conplidate.setCcardnum(ccardnum);
		conplidate.setCcollege(ccollege);
		conplidate.setCzhuanye(czhuanye);
		conplidateDao.save(conplidate);
		System.out.println("已上传简历");
		return conplidate;
	}
	
	@RequestMapping("/list")
	public Map<String, Object> listconplidate(){
		List<Conplidate>list=conplidateDao.findAll();
		Map<String, Object> result=new HashMap<>();
		result.put("total", list.size());
		result.put("rows", list);
		return result;
	}
	
	@RequestMapping("/getbycworktype")
	public List<Conplidate> listconplidates(String cworktype){
		List<Conplidate> list=conplidateDao.findByCworktype(cworktype);
		return list;
	}
	
	@RequestMapping("/getbyuser")
	public Conplidate findconplidate(Long uid){
		Conplidate conplidate=conplidateDao.findByUid(uid);
		return conplidate;
	}
	
}
