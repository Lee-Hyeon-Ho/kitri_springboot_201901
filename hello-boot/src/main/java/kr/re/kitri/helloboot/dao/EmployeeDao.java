package kr.re.kitri.helloboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.re.kitri.helloboot.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee insertEmployee(Employee emp) {
		String sql = "INSERT INTO EMPLOYEE (EMP_ID, NAME, POSITION, AGE) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, emp.getEmpId(), emp.getName(), emp.getPosition(), emp.getAge());
		return emp;
	}

	public List<Employee> selectAllEmployees() {
		String sql = "SELECT EMP_ID, NAME, POSITION, AGE FROM EMPLOYEE";
		return jdbcTemplate.query(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPosition(rs.getString(3));
				emp.setAge(rs.getInt(4));
				return emp;
			}
		});
	}

	public Employee selectEmployeeById(String empId) {
		String sql = "SELECT EMP_ID, NAME, POSITION, AGE FROM EMPLOYEE WHERE EMP_ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {empId}, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPosition(rs.getString(3));
				emp.setAge(rs.getInt(4));
				return emp;
			}
		});
	}
	
}
