package kr.re.kitri.helloboot.model;

public class Employee {
	
	private int empId;
	private String name;
	private String position;
	private int age;
	
	public Employee() {}
	public Employee(int empId, String name, String position, int age) {
		this.empId = empId;
		this.name = name;
		this.position = position;
		this.age = age;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", position=" + position + ", age=" + age + "]";
	}
	
}
