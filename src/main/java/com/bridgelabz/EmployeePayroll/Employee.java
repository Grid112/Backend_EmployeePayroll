package com.bridgelabz.EmployeePayroll;

public class Employee {

	private String name, gender, city, department;
	private long salary, phoneNo;
	private int id;

	public Employee() {
		super();
	}

	public Employee(String name, String gender, String city, String department, long salary, long phoneNo, int id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.city = city;
		this.department = department;
		this.salary = salary;
		this.phoneNo = phoneNo;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", city=" + city + ", department=" + department
				+ ", salary=" + salary + ", phoneNo=" + phoneNo + "]";
	}

	

}
