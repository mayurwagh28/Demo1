package example.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.spring.mvc.model.User;
import example.spring.mvc.model.UserValidator;

@Controller // Mark class as MVC Controller
public class SpringMvcController {
	
	@RequestMapping("/showIndex")
	public String getIndexPageName() {
		String indexPageName = "index";
		return indexPageName;
	}
	
	@RequestMapping("/")
	public String getLoginPage() {
		String loginPageName = "Login";
		return loginPageName;
	}
	
	@RequestMapping(value="/doValidate" , method = RequestMethod.POST)//config this endpt to handle http post request
	public String getResultPageAfterUserValidation(@RequestParam("user_name")String uid ,@RequestParam("user_pass")  String pwd) {
//		Populating model obj  : user based upon uid & pwd
		User u1 = new User(uid , pwd);
//		Passing this model obj to another model
		String resPageName = "Fail";
		boolean valid = UserValidator.isValid(u1);
		if(valid)
			resPageName = "Success";
	return resPageName;
	}
}
