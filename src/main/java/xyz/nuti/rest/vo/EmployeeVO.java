package xyz.nuti.rest.vo;

public class EmployeeVO {
	private int employeeNo;
	private String name;
	private String dept;
	private int age;
	
	public EmployeeVO() {
		
	}
	
	public EmployeeVO(int employeeNo, String name, String dept, int age) {
		this.employeeNo = employeeNo;
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
