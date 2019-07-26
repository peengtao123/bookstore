package org.crazyit.test.service;

import org.crazyit.test.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user", url = "http://localhost:9000/user")
public interface UserService {

	@RequestMapping(method = RequestMethod.GET, value = "/validate/{name}/{password}")
	User validate(@PathVariable("name") String name,
			@PathVariable("password") String password);
}
