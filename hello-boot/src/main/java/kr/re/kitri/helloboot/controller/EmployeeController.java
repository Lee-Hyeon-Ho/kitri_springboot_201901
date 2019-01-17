package kr.re.kitri.helloboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.helloboot.model.Employee;
import kr.re.kitri.helloboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService service;
	
	// 직원 전체 조회
	@GetMapping("/employees")
	public List<Employee> searchEmployees() {
		List<Employee> emps = service.retrieveAllEmployees();
		System.out.println(emps);
		return emps;
	}
	
	// 직원 번호로 상세조회
	@GetMapping("/employees/{empId}")
	public Employee searchEmployeeById(@PathVariable String empId) {
		logger.debug(empId + "====================================");
		logger.debug(empId + "번 직원 조회");
		return service.searchEmployeeById(empId);
	}
	
	// 직원 삭제
	@DeleteMapping("/employees/{empId}")
	public Employee removeEmployeeById(@PathVariable String empId) {
		System.out.println("삭제 - 직원번호 : " + empId);
		Employee emp = new Employee();
		emp.setEmpId(Integer.parseInt(empId));
		return emp;
	}
	
	// 직원 등록
	@PostMapping("/employees")
	public Employee registEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		// 파라미터(직원정보) 확보 후 데이터베이스에 인서트한다.
		Employee registered = service.registEmployee(emp);
		System.out.println("insert ok..");
		return registered;
	}
	
	// 직원 정보 수정
	@PutMapping("/employees/{empId}")
	public Employee modifyEmployeeById() {
		return null;
	}
}
