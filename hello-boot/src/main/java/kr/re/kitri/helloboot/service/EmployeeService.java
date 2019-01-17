package kr.re.kitri.helloboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.helloboot.dao.EmployeeDao;
import kr.re.kitri.helloboot.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee registEmployee(Employee emp) {
		return employeeDao.insertEmployee(emp);
	}

	public List<Employee> retrieveAllEmployees() {
		return employeeDao.selectAllEmployees();
	}

	public Employee searchEmployeeById(String empId) {
		return employeeDao.selectEmployeeById(empId);
	}
}
