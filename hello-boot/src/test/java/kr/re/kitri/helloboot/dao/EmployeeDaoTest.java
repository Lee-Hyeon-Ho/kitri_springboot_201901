package kr.re.kitri.helloboot.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.re.kitri.helloboot.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void testSelectAllEmployees() {
		List<Employee> result = employeeDao.selectAllEmployees();
		Assert.assertTrue(result.size() > 0);
	}
	
	@Test
	public void testSelectEmployeeById() {
		Employee emp = employeeDao.selectEmployeeById("2");
		Assert.assertTrue(emp.getEmpId() == 2);
	}
	
	@Ignore
	public void testInsertEmployee() {
		Employee emp = new Employee(2, "park", "부장", 50);
		Employee inserted = employeeDao.insertEmployee(emp);
		Assert.assertTrue(inserted.getEmpId() == 2);
	}
	
}
