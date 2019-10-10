package test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Testcontroller {
	 @RequestMapping("/helloworld")
	    public String HelloSpring (){
	        System.out.println("hello world!");
	        return " hello world!";
	    }
}
