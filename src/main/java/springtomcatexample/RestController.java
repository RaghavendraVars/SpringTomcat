package springtomcatexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alien;
import model.User;

@Controller
public class RestController {

	@Autowired
	App app;
	
	//I am Checking the changes in GITHUB
	@RequestMapping("/getVars")
	public String getVars(){
		return "index";
	}
	
	@RequestMapping("/getUsers")
	public @ResponseBody List getUsers(){
		List<User> lists = app.getUsers();
		return lists;
	}
	
	@RequestMapping("/getAliens")
	public @ResponseBody List getAliens(){
		List<Alien> lists = app.getAliens();
		return lists;
    }
	
	@RequestMapping("/postUser")
	public @ResponseBody User postUser(@RequestBody User user){
		app.addUser(user);
		return user;
	}
	
	@RequestMapping("/postAlien")
	public @ResponseBody Alien postAlien(@RequestBody Alien alien){
		app.addAlien(alien);
		return alien;
	}
}
