package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.dao.UserDao;
import test.entity.User;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(value="/aduser")
	public User addUser(User u) {
		userDao.save(u);
		return u;
	}
	
	@RequestMapping(value="/register")
	public User register(String username, String password) {
		System.out.println ( "微信小程序调用接口！！！用户名:" + username);
		User user= new User();
		user.setUserName(username);
		user.setPwd(password);
		userDao.save(user);
		System.out.println("已保存用户");
		return user;
	}
	
	@RequestMapping("/get")
	public User finduser(String username, String password){
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	@RequestMapping("/getbyusername")
	public User finduser(String username){
		System.out.println ( "微信小程序调用getbyusername接口");
		return userDao.findByUsername(username);
	}
	@RequestMapping("/updateuser")
	public Boolean updateuser(String username,String repassword){
		System.out.println ( "微信小程序调updatauser接口");
		User user=userDao.findByUsername(username);
		user.setPwd(repassword);
		userDao.save(user);
		return true;
		
	}
	@RequestMapping("/login")
	public  User login(String username, String password){
		System.out.println ( "微信小程序调用接口！！！用户名:" + username + "密码:" + password );
		User user=userDao.findByUsernameAndPassword(username, password);
		if(user!=null) {
				System.out.println("登录成功");
			}else {
				System.out.println("密码错误"); 
				
			}
			return user;
		}	
}
