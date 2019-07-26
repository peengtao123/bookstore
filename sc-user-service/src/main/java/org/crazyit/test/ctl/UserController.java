package org.crazyit.test.ctl;

import org.crazyit.test.entity.User;
import org.crazyit.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/validate/{name}/{password}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User validate(@PathVariable String name, @PathVariable String password) {
		return userService.findByNameAndPassowrd(name, password);
	}
}
