package in.dj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControll {

	@GetMapping("/")
	public String greet() {
		return "Hello am from  STS";
	}
	
}
