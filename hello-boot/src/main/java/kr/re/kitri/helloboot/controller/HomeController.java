package kr.re.kitri.helloboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.helloboot.model.Employee;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Hello, Home";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World";
	}
	
	@PostMapping("/hello")
	public String hello3() {
		return "Hello, Post World";
	}
	
	@GetMapping("/employee/235")
	public Employee hello2() {
		
		Employee emp235 = new Employee();
		emp235.setEmpId(235);
		emp235.setName("kim");
		emp235.setPosition("과장");
		emp235.setAge(35);
		
		return emp235;
	}
	
}
